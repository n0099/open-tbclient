package com.kwad.sdk.glide.load.resource.b;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.ar.constants.HttpConstants;
import com.kwad.sdk.glide.load.engine.s;
import com.kwad.sdk.glide.load.f;
import java.util.List;
/* loaded from: classes3.dex */
public class d implements f<Uri, Drawable> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f10263a;

    public d(Context context) {
        this.f10263a = context.getApplicationContext();
    }

    @DrawableRes
    private int a(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 2) {
            return b(context, uri);
        }
        if (pathSegments.size() == 1) {
            return a(uri);
        }
        throw new IllegalArgumentException("Unrecognized Uri format: " + uri);
    }

    @DrawableRes
    private int a(Uri uri) {
        try {
            return Integer.parseInt(uri.getPathSegments().get(0));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Unrecognized Uri format: " + uri, e);
        }
    }

    @NonNull
    private Context a(Uri uri, String str) {
        if (str.equals(this.f10263a.getPackageName())) {
            return this.f10263a;
        }
        try {
            return this.f10263a.createPackageContext(str, 0);
        } catch (PackageManager.NameNotFoundException e) {
            if (str.contains(this.f10263a.getPackageName())) {
                return this.f10263a;
            }
            throw new IllegalArgumentException("Failed to obtain context or unrecognized Uri format for: " + uri, e);
        }
    }

    @DrawableRes
    private int b(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        String authority = uri.getAuthority();
        String str = pathSegments.get(0);
        String str2 = pathSegments.get(1);
        int identifier = context.getResources().getIdentifier(str2, str, authority);
        int identifier2 = identifier == 0 ? Resources.getSystem().getIdentifier(str2, str, HttpConstants.OS_TYPE_VALUE) : identifier;
        if (identifier2 == 0) {
            throw new IllegalArgumentException("Failed to find resource id for: " + uri);
        }
        return identifier2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.f
    @Nullable
    public s<Drawable> a(@NonNull Uri uri, int i, int i2, @NonNull com.kwad.sdk.glide.load.e eVar) {
        Context a2 = a(uri, uri.getAuthority());
        return c.a(a.a(this.f10263a, a2, a(a2, uri)));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.f
    public boolean a(@NonNull Uri uri, @NonNull com.kwad.sdk.glide.load.e eVar) {
        return uri.getScheme().equals("android.resource");
    }
}
