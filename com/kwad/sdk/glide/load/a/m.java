package com.kwad.sdk.glide.load.a;

import android.content.res.AssetManager;
import androidx.annotation.NonNull;
import java.io.InputStream;
/* loaded from: classes5.dex */
public class m extends b<InputStream> {
    public m(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    @Override // com.kwad.sdk.glide.load.a.d
    @NonNull
    public Class<InputStream> a() {
        return InputStream.class;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.glide.load.a.b
    public void a(InputStream inputStream) {
        inputStream.close();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.glide.load.a.b
    /* renamed from: b */
    public InputStream a(AssetManager assetManager, String str) {
        return assetManager.open(str);
    }
}
