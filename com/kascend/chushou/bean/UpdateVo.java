package com.kascend.chushou.bean;

import android.text.TextUtils;
/* loaded from: classes6.dex */
public class UpdateVo {
    public String apk_name;
    public String apk_versionCode;
    public String uri;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof UpdateVo) {
            UpdateVo updateVo = (UpdateVo) obj;
            return TextUtils.equals(updateVo.apk_name, this.apk_name) && TextUtils.equals(updateVo.apk_versionCode, this.apk_versionCode) && TextUtils.equals(updateVo.uri, this.uri);
        }
        return false;
    }

    public int hashCode() {
        return (((this.apk_versionCode == null ? 0 : this.apk_versionCode.hashCode()) + (((this.uri == null ? 0 : this.uri.hashCode()) + 527) * 31)) * 31) + (this.apk_name != null ? this.apk_name.hashCode() : 0);
    }
}
