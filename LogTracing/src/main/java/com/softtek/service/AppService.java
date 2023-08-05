package com.softtek.service;

import java.util.List;

import com.softtek.form.ApplicationDtlsForm;

public interface AppService {
	public boolean saveAppDtls(ApplicationDtlsForm applicationDtlsForm);
	public List<ApplicationDtlsForm> listApplicationDtlsForm();
}
