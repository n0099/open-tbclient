package com.kwad.sdk.glide.load.a;

import android.content.res.AssetManager;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
/* loaded from: classes5.dex */
public class h extends b<ParcelFileDescriptor> {
    public h(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    @Override // com.kwad.sdk.glide.load.a.d
    @NonNull
    public Class<ParcelFileDescriptor> a() {
        return ParcelFileDescriptor.class;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.glide.load.a.b
    public void a(ParcelFileDescriptor parcelFileDescriptor) {
        parcelFileDescriptor.close();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.glide.load.a.b
    /* renamed from: b */
    public ParcelFileDescriptor a(AssetManager assetManager, String str) {
        return assetManager.openFd(str).getParcelFileDescriptor();
    }
}
