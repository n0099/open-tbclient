package com.kwad.sdk.glide.load.resource.b;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.common.util.UriUtil;
import com.kwad.sdk.glide.load.engine.s;
import com.kwad.sdk.glide.load.f;
import java.util.List;
/* loaded from: classes6.dex */
public class d implements f<Uri, Drawable> {

    /* renamed from: a  reason: collision with root package name */
    public final Context f35924a;

    public d(Context context) {
        this.f35924a = context.getApplicationContext();
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
        } catch (NumberFormatException e2) {
            throw new IllegalArgumentException("Unrecognized Uri format: " + uri, e2);
        }
    }

    @NonNull
    private Context a(Uri uri, String str) {
        if (str.equals(this.f35924a.getPackageName())) {
            return this.f35924a;
        }
        try {
            return this.f35924a.createPackageContext(str, 0);
        } catch (PackageManager.NameNotFoundException e2) {
            if (str.contains(this.f35924a.getPackageName())) {
                return this.f35924a;
            }
            throw new IllegalArgumentException("Failed to obtain context or unrecognized Uri format for: " + uri, e2);
        }
    }

    @DrawableRes
    private int b(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        String authority = uri.getAuthority();
        String str = pathSegments.get(0);
        String str2 = pathSegments.get(1);
        int identifier = context.getResources().getIdentifier(str2, str, authority);
        if (identifier == 0) {
            identifier = Resources.getSystem().getIdentifier(str2, str, "android");
        }
        if (identifier != 0) {
            return identifier;
        }
        throw new IllegalArgumentException("Failed to find resource id for: " + uri);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.f
    @Nullable
    public s<Drawable> a(@NonNull Uri uri, int i, int i2, @NonNull com.kwad.sdk.glide.load.e eVar) {
        Context a2 = a(uri, uri.getAuthority());
        return c.a(a.a(this.f35924a, a2, a(a2, uri)));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.f
    public boolean a(@NonNull Uri uri, @NonNull com.kwad.sdk.glide.load.e eVar) {
        return uri.getScheme().equals(UriUtil.QUALIFIED_RESOURCE_SCHEME);
    }
}
