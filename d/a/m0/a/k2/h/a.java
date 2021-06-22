package d.a.m0.a.k2.h;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.storage.swankv.AshmemFileDescriptor;
/* loaded from: classes3.dex */
public class a extends ProviderDelegation {
    @Nullable
    public static AshmemFileDescriptor a(@NonNull String str, int i2) {
        Bundle bundle = new Bundle();
        bundle.putString("name", str);
        bundle.putInt("size", i2);
        d.a.m0.a.v1.b.f b2 = d.a.m0.a.v1.b.d.b(a.class, bundle);
        if (b2.a()) {
            b2.f49079a.setClassLoader(AshmemFileDescriptor.class.getClassLoader());
            return (AshmemFileDescriptor) b2.f49079a.getParcelable("result");
        }
        return null;
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
    public Bundle execCall(Bundle bundle) {
        String string = bundle.getString("name", null);
        int i2 = bundle.getInt("size", 0);
        Bundle bundle2 = new Bundle();
        bundle2.setClassLoader(AshmemFileDescriptor.class.getClassLoader());
        bundle2.putParcelable("result", f.a(string, i2));
        return bundle2;
    }
}
