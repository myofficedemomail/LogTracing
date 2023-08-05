package com.softtek.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.entity.AppEntity;
import com.softtek.form.ApplicationDtlsForm;
import com.softtek.repo.AppRepo;

@Service
public class AppServiceImpl implements AppService {
	@Autowired
	private AppRepo appRepo;

	@Override
	public boolean saveAppDtls(ApplicationDtlsForm applicationDtlsForm) {
		AppEntity appEntity = new AppEntity();
		appEntity.setApplicationName(applicationDtlsForm.getApplicationName());
		appEntity.setServerName(applicationDtlsForm.getServerName());
		appEntity = appRepo.save(appEntity);
		if (appEntity != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<ApplicationDtlsForm> listApplicationDtlsForm() {
		List<ApplicationDtlsForm> listApplicationDtlsForm = new ArrayList<>();
		List<AppEntity> findAll = appRepo.findAll();
		ApplicationDtlsForm applicationDtlsForm = null;
		for (AppEntity appEntity : findAll) {
			applicationDtlsForm = new ApplicationDtlsForm();
			applicationDtlsForm.setApplicationName(appEntity.getApplicationName());
			applicationDtlsForm.setServerName(applicationDtlsForm.getServerName());
			listApplicationDtlsForm.add(applicationDtlsForm);
		}
		return listApplicationDtlsForm;
	}

}
