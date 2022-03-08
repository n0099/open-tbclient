package com.kwad.sdk.kwai;

import android.location.Location;
import com.kuaishou.weapon.IWeaponInitParams;
import com.kwad.sdk.core.config.b;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.av;
import java.util.List;
/* loaded from: classes8.dex */
public class a implements IWeaponInitParams {
    @Override // com.kuaishou.weapon.IWeaponInitParams
    public String getAndroidID() {
        return ao.f();
    }

    @Override // com.kuaishou.weapon.IWeaponInitParams
    public String getAppKey() {
        return "400000";
    }

    @Override // com.kuaishou.weapon.IWeaponInitParams
    public String getChannel() {
        return "";
    }

    @Override // com.kuaishou.weapon.IWeaponInitParams
    public String getDeviceId() {
        return av.u();
    }

    @Override // com.kuaishou.weapon.IWeaponInitParams
    public String getHost() {
        return "";
    }

    @Override // com.kuaishou.weapon.IWeaponInitParams
    public String getImei() {
        return ao.d();
    }

    @Override // com.kuaishou.weapon.IWeaponInitParams
    public String[] getImeis() {
        return ao.e();
    }

    @Override // com.kuaishou.weapon.IWeaponInitParams
    public List<String> getInstalledPackages() {
        return ao.n();
    }

    @Override // com.kuaishou.weapon.IWeaponInitParams
    public Location getLocation() {
        return ao.b();
    }

    @Override // com.kuaishou.weapon.IWeaponInitParams
    public String getMacAddress() {
        return ao.h();
    }

    @Override // com.kuaishou.weapon.IWeaponInitParams
    public String getOaid() {
        return com.kwad.sdk.core.f.a.a();
    }

    @Override // com.kuaishou.weapon.IWeaponInitParams
    public int getPS() {
        long j2 = ao.c() ? 4227L : 0L;
        if (ao.g()) {
            j2 |= 4;
        }
        if (ao.i()) {
            j2 |= 2048;
        }
        if (ao.l()) {
            j2 |= 8192;
        }
        if (ao.a()) {
            j2 |= 64;
        }
        if (ao.k()) {
            j2 |= 40;
        }
        if (ao.m()) {
            j2 |= 16;
        }
        return (int) (j2 | b.Y());
    }

    @Override // com.kuaishou.weapon.IWeaponInitParams
    public boolean getPrivacySwitch() {
        return true;
    }

    @Override // com.kuaishou.weapon.IWeaponInitParams
    public String getProductName() {
        return "ksadsdk";
    }

    @Override // com.kuaishou.weapon.IWeaponInitParams
    public String getSecKey() {
        return "f12536c198aee4d8198aad2300827430";
    }

    @Override // com.kuaishou.weapon.IWeaponInitParams
    public String getUserId() {
        return "";
    }
}
