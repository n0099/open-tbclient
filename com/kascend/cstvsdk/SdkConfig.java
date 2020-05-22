package com.kascend.cstvsdk;

import android.app.Application;
import android.content.res.Resources;
import android.support.annotation.Keep;
import com.kascend.cstvsdk.interfaces.ThirdParty;
import java.util.Map;
import kotlin.h;
import kotlin.jvm.internal.q;
import okhttp3.OkHttpClient;
@Keep
@h
/* loaded from: classes5.dex */
public final class SdkConfig {
    private Application application;
    private boolean debug;
    private boolean initFresco;
    private OkHttpClient okhttp;
    private Resources resources;
    private Map<String, String> sdkHostParams;
    private String server = "beta";
    private Class<? extends ThirdParty> thirdParty;
    private String xappkey;
    private String xsecret;

    public final String getXappkey() {
        return this.xappkey;
    }

    public final void setXappkey(String str) {
        this.xappkey = str;
    }

    public final String getXsecret() {
        return this.xsecret;
    }

    public final void setXsecret(String str) {
        this.xsecret = str;
    }

    public final String getServer() {
        return this.server;
    }

    public final void setServer(String str) {
        q.m(str, "<set-?>");
        this.server = str;
    }

    public final Application getApplication() {
        return this.application;
    }

    public final void setApplication(Application application) {
        this.application = application;
    }

    public final OkHttpClient getOkhttp() {
        return this.okhttp;
    }

    public final void setOkhttp(OkHttpClient okHttpClient) {
        this.okhttp = okHttpClient;
    }

    public final Class<? extends ThirdParty> getThirdParty() {
        return this.thirdParty;
    }

    public final void setThirdParty(Class<? extends ThirdParty> cls) {
        this.thirdParty = cls;
    }

    public final Resources getResources() {
        return this.resources;
    }

    public final void setResources(Resources resources) {
        this.resources = resources;
    }

    public final boolean getInitFresco() {
        return this.initFresco;
    }

    public final void setInitFresco(boolean z) {
        this.initFresco = z;
    }

    public final Map<String, String> getSdkHostParams() {
        return this.sdkHostParams;
    }

    public final void setSdkHostParams(Map<String, String> map) {
        this.sdkHostParams = map;
    }

    public final boolean getDebug() {
        return this.debug;
    }

    public final void setDebug(boolean z) {
        this.debug = z;
    }
}
