package d.a.h0.a.a2.g;

import android.os.Bundle;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final String f41256a;

    /* renamed from: b  reason: collision with root package name */
    public final int f41257b;

    /* renamed from: c  reason: collision with root package name */
    public final String f41258c;

    /* renamed from: d  reason: collision with root package name */
    public final String f41259d;

    public c(String str, int i2, String str2, String str3) {
        this.f41256a = str;
        this.f41257b = i2;
        this.f41258c = str2;
        this.f41259d = str3;
    }

    public static Bundle a(String str, int i2, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString("bundle_sp_name_key", str);
        bundle.putString("bundle_prefs_key", str2);
        bundle.putInt("bundle_data_type_key", i2);
        bundle.putString("bundle_data_value_key", str3);
        return bundle;
    }

    public static c b(Bundle bundle) {
        if (bundle.isEmpty()) {
            return null;
        }
        return new c(bundle.getString("bundle_sp_name_key"), bundle.getInt("bundle_data_type_key"), bundle.getString("bundle_prefs_key"), bundle.getString("bundle_data_value_key"));
    }

    public String toString() {
        return "SpMethodInfo{mDataType=" + this.f41257b + ", mPrefName='" + this.f41258c + "', mDataValue='" + this.f41259d + "'}";
    }
}
