package d.b.h0.a.a2.g;

import android.os.Bundle;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final String f43986a;

    /* renamed from: b  reason: collision with root package name */
    public final int f43987b;

    /* renamed from: c  reason: collision with root package name */
    public final String f43988c;

    /* renamed from: d  reason: collision with root package name */
    public final String f43989d;

    public c(String str, int i, String str2, String str3) {
        this.f43986a = str;
        this.f43987b = i;
        this.f43988c = str2;
        this.f43989d = str3;
    }

    public static Bundle a(String str, int i, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString("bundle_sp_name_key", str);
        bundle.putString("bundle_prefs_key", str2);
        bundle.putInt("bundle_data_type_key", i);
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
        return "SpMethodInfo{mDataType=" + this.f43987b + ", mPrefName='" + this.f43988c + "', mDataValue='" + this.f43989d + "'}";
    }
}
