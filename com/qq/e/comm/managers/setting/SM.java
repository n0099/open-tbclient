package com.qq.e.comm.managers.setting;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.qq.e.comm.managers.setting.e;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import com.qq.e.comm.util.SystemUtil;
import java.io.File;
import java.io.IOException;
/* loaded from: classes6.dex */
public class SM {

    /* renamed from: b  reason: collision with root package name */
    public String f38319b;

    /* renamed from: c  reason: collision with root package name */
    public a f38320c;

    /* renamed from: e  reason: collision with root package name */
    public String f38322e;

    /* renamed from: f  reason: collision with root package name */
    public d f38323f;
    public String i;
    public String k;
    public Context m;

    /* renamed from: g  reason: collision with root package name */
    public d f38324g = null;
    public String l = "";

    /* renamed from: a  reason: collision with root package name */
    public a f38318a = new a();

    /* renamed from: d  reason: collision with root package name */
    public a f38321d = new a();

    /* renamed from: h  reason: collision with root package name */
    public d f38325h = new b();
    public c j = new c();
    public String n = SystemUtil.buildNewPathByProcessName("e_qq_com_setting");

    public SM(Context context) {
        this.m = context;
        try {
            this.k = StringUtil.readAll(new File(this.m.getDir(this.n, 0), "gdt_suid"));
        } catch (Throwable unused) {
            this.k = null;
            GDTLogger.e("IO Exception while loading suid");
        }
        a();
        b();
        c();
    }

    private void a() {
        e.a<d> b2 = e.b(this.m);
        if (b2 == null) {
            GDTLogger.d("Load Local SDK Cloud setting fail");
            return;
        }
        this.f38322e = b2.a();
        this.f38323f = b2.b();
    }

    private void b() {
        e.a<a> a2 = e.a(this.m);
        if (a2 == null) {
            GDTLogger.d("Load Local DEV Cloud setting fail");
            return;
        }
        this.f38320c = a2.b();
        this.f38319b = a2.a();
    }

    private void c() {
        e.a<c> c2 = e.c(this.m);
        if (c2 == null) {
            GDTLogger.d("Load Local DEV Cloud setting fail");
            return;
        }
        this.j = c2.b();
        this.i = c2.a();
    }

    public Object get(String str) {
        Object a2;
        Object a3;
        Object a4;
        Object a5;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            if (this.f38318a == null || (a5 = this.f38318a.a(str)) == null) {
                if (this.f38320c == null || (a4 = this.f38320c.a(str)) == null) {
                    if (this.f38321d == null || (a3 = this.f38321d.a(str)) == null) {
                        if (this.f38323f == null || (a2 = this.f38323f.a(str)) == null) {
                            if (this.f38325h != null) {
                                return this.f38325h.a(str);
                            }
                            return null;
                        }
                        return a2;
                    }
                    return a3;
                }
                return a4;
            }
            return a5;
        } catch (Throwable th) {
            GDTLogger.report("Exception in settingManager.get Setting for key:" + str, th);
            return null;
        }
    }

    public Object getDebugSetting() {
        return null;
    }

    public String getDevCloudSettingSig() {
        return this.f38319b;
    }

    public Object getForPlacement(String str, String str2) {
        Object a2;
        Object a3;
        Object a4;
        Object a5;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (TextUtils.isEmpty(str2)) {
            return get(str);
        }
        try {
            return (this.j == null || (a5 = this.j.a(str, str2)) == null) ? (this.f38318a == null || (a4 = this.f38318a.a(str, str2)) == null) ? (this.f38320c == null || (a3 = this.f38320c.a(str, str2)) == null) ? (this.f38321d == null || (a2 = this.f38321d.a(str, str2)) == null) ? get(str) : a2 : a3 : a4 : a5;
        } catch (Throwable th) {
            GDTLogger.report("Exception in settingManager.getForPlacement", th);
            return null;
        }
    }

    public int getInteger(String str, int i) {
        Object obj = get(str);
        return (obj == null || !(obj instanceof Integer)) ? i : ((Integer) obj).intValue();
    }

    public int getIntegerForPlacement(String str, String str2, int i) {
        Object forPlacement = getForPlacement(str, str2);
        return (forPlacement == null || !(forPlacement instanceof Integer)) ? i : ((Integer) forPlacement).intValue();
    }

    public String getPlacementCloudSettingSig() {
        return this.i;
    }

    public String getSdkCloudSettingSig() {
        return this.f38322e;
    }

    public String getSettingDir() {
        return this.n;
    }

    public String getSid() {
        return this.l;
    }

    public String getString(String str) {
        Object obj = get(str);
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    public String getString(String str, String str2) {
        Object obj = get(str);
        return obj == null ? str2 : obj.toString();
    }

    public String getStringForPlacement(String str, String str2) {
        Object forPlacement = getForPlacement(str, str2);
        if (forPlacement == null) {
            return null;
        }
        return forPlacement.toString();
    }

    public String getSuid() {
        return this.k;
    }

    public void modifyDebugSetting(String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
        }
    }

    public void setDEVCodeSetting(String str, Object obj) {
        this.f38321d.a(str, obj);
    }

    public void setDEVCodeSetting(String str, Object obj, String str2) {
        this.f38321d.a(str, obj, str2);
    }

    public void updateContextSetting(String str) {
        try {
            a aVar = new a();
            if (!TextUtils.isEmpty(str)) {
                aVar = new a(new String(Base64.decode(str, 0), "UTF-8"));
            }
            this.f38318a = aVar;
        } catch (Throwable th) {
            GDTLogger.report("Exception while update Context Setting", th);
        }
    }

    public void updateDEVCloudSetting(String str, String str2) {
        if (e.b(this.m, str, str2)) {
            b();
        }
    }

    public void updatePlacementSetting(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            e.d(this.m);
            this.j = new c();
            this.i = null;
        } else if (e.c(this.m, str, str2)) {
            c();
        }
    }

    public void updateSDKCloudSetting(String str, String str2) {
        if (e.a(this.m, str, str2)) {
            a();
        }
    }

    public void updateSID(String str) {
        this.l = str;
    }

    public void updateSUID(String str) {
        if (TextUtils.isEmpty(str) || str.equals(this.k)) {
            return;
        }
        this.k = str;
        try {
            StringUtil.writeTo(str, new File(this.m.getDir(this.n, 0), "gdt_suid"));
        } catch (IOException e2) {
            GDTLogger.report("Exception while persit suid", e2);
        }
    }
}
