package d.a.l0.e.m.a;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.mobstat.Config;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.spswitch.emotion.resource.EmotionResourceProvider;
import com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity;
import com.baidu.swan.apps.media.chooser.model.ImageModel;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.swan.facade.picture.wallpaper.PictureWallpaperActivity;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.a.l0.a.h;
import d.a.l0.a.p.d.h0;
import d.a.l0.a.s1.f;
import d.a.l0.a.v2.u;
import d.a.l0.a.z1.b.f.e;
import d.a.l0.t.d;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes3.dex */
public class a implements h0 {

    /* renamed from: d.a.l0.e.m.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1021a extends BaseBitmapDataSubscriber {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f50221a;

        public C1021a(a aVar, Context context) {
            this.f50221a = context;
        }

        @Override // com.facebook.datasource.BaseDataSubscriber
        public void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
            e.f(this.f50221a, h.swan_app_img_menu_save_failed).u();
        }

        @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
        public void onNewResultImpl(Bitmap bitmap) {
            a.i(this.f50221a, bitmap);
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f50222a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Bitmap f50223b;

        public b(Context context, Bitmap bitmap) {
            this.f50222a = context;
            this.f50223b = bitmap;
        }

        @Override // d.a.l0.a.s1.f
        public void a(String str) {
            a.l(this.f50222a, this.f50223b);
        }

        @Override // d.a.l0.a.s1.f
        public void b(int i2, String str) {
            e.f(this.f50222a, h.swan_app_img_menu_save_failed).u();
        }
    }

    public static void i(Context context, Bitmap bitmap) {
        d.a.l0.a.s1.e.e(StorageUtils.EXTERNAL_STORAGE_PERMISSION, new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, 3, context, new b(context, bitmap));
    }

    public static boolean k(@NonNull Context context, @NonNull Bitmap bitmap, @NonNull String str) {
        String p = d.p(str);
        if (bitmap.hasAlpha() && !"png".equalsIgnoreCase(p)) {
            str = d.r(str) + EmotionResourceProvider.EMOTION_RES_NAME_SUFFIX;
            p = "png";
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if ("png".equalsIgnoreCase(p)) {
            bitmap.compress(Bitmap.CompressFormat.PNG, 80, byteArrayOutputStream);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            if (Build.VERSION.SDK_INT >= 29) {
                return m(context, byteArrayInputStream, "image/png", str);
            }
            String str2 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + File.separator + "Image" + File.separator + str;
            boolean p2 = u.p(bitmap, str2, 80, Bitmap.CompressFormat.PNG);
            if (p2) {
                u.q(context, str2);
            }
            return p2;
        }
        bitmap.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream);
        ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        if (Build.VERSION.SDK_INT >= 29) {
            return m(context, byteArrayInputStream2, "image/jpeg", str);
        }
        String str3 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + File.separator + "Image" + File.separator + str;
        boolean p3 = u.p(bitmap, str3, 80, Bitmap.CompressFormat.JPEG);
        if (p3) {
            u.q(context, str3);
        }
        return p3;
    }

    public static void l(Context context, Bitmap bitmap) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss", Locale.CHINA);
        if (k(context, bitmap, "IMG_" + simpleDateFormat.format(new Date()) + ".jpg")) {
            e.f(context, h.swan_app_img_menu_save_success).u();
        } else {
            e.f(context, h.swan_app_img_menu_save_failed).u();
        }
    }

    public static boolean m(@NonNull Context context, @NonNull InputStream inputStream, @NonNull String str, @NonNull String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", str2);
        contentValues.put("mime_type", str);
        if (Build.VERSION.SDK_INT >= 29) {
            contentValues.put("relative_path", Environment.DIRECTORY_PICTURES + "/Image/");
        } else {
            contentValues.put("_data", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getPath() + "/Image");
        }
        Uri insert = context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
        if (insert == null) {
            d.a.l0.a.e0.d.l("FacadeSwanAppImageImpl", "insert uri is null");
            return false;
        }
        try {
            OutputStream openOutputStream = context.getContentResolver().openOutputStream(insert);
            if (openOutputStream == null) {
                d.d(openOutputStream);
                return false;
            }
            byte[] bArr = new byte[4096];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    openOutputStream.write(bArr, 0, read);
                } else {
                    d.d(openOutputStream);
                    return true;
                }
            }
        } catch (IOException unused) {
            d.d(null);
            return false;
        } catch (Throwable th) {
            d.d(null);
            throw th;
        }
    }

    @Override // d.a.l0.a.p.d.h0
    public void a(Context context, JSONObject jSONObject) {
        PictureWallpaperActivity.launchWallpaperActivity(context, jSONObject.optString("imageUrl"), jSONObject.optString(Config.LAUNCH_REFERER));
    }

    @Override // d.a.l0.a.p.d.h0
    public void b(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        int optInt = jSONObject.optInt("index");
        JSONArray optJSONArray = jSONObject.optJSONArray("urls");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return;
        }
        int length = optJSONArray.length();
        ArrayList<MediaModel> arrayList = new ArrayList<>(length);
        for (int i2 = 0; i2 < length; i2++) {
            String optString = optJSONArray.optString(i2);
            if (!TextUtils.isEmpty(optString)) {
                arrayList.add(new ImageModel(optString));
            }
        }
        j(context, arrayList, optInt);
    }

    @Override // d.a.l0.a.p.d.h0
    public void c(GenericDraweeHierarchy genericDraweeHierarchy, boolean z) {
    }

    @Override // d.a.l0.a.p.d.h0
    public void d(Context context, String[] strArr, int i2) {
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        ArrayList<MediaModel> arrayList = new ArrayList<>(strArr.length);
        for (String str : strArr) {
            arrayList.add(new ImageModel(str));
        }
        j(context, arrayList, i2);
    }

    @Override // d.a.l0.a.p.d.h0
    public ImageRequestBuilder e(ImageRequestBuilder imageRequestBuilder, Map<String, String> map) {
        return imageRequestBuilder;
    }

    @Override // d.a.l0.a.p.d.h0
    public void f(Context context, JSONObject jSONObject) {
        String optString = jSONObject.optString("imageUrl");
        String optString2 = jSONObject.optString(Config.LAUNCH_REFERER);
        ImageRequestBuilder newBuilderWithSource = ImageRequestBuilder.newBuilderWithSource(Uri.parse(optString));
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(optString2)) {
            hashMap.put(Config.LAUNCH_REFERER, optString2);
        }
        d.a.l0.a.c1.a.y().e(newBuilderWithSource, hashMap);
        Fresco.getImagePipeline().fetchDecodedImage(newBuilderWithSource.build(), context).subscribe(new C1021a(this, context), UiThreadImmediateExecutorService.getInstance());
    }

    public final void j(Context context, ArrayList<MediaModel> arrayList, int i2) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("mediaModels", arrayList);
        bundle.putInt("previewPosition", i2);
        bundle.putString("previewFrom", UnitedSchemeConstants.SCHEME_INVOKE_TYPE_OUTSIDE);
        Intent intent = new Intent(context, SwanAppAlbumPreviewActivity.class);
        intent.putExtra("launchParams", bundle);
        context.startActivity(intent);
    }
}
