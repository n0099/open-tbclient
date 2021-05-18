package d.a.i0.a.c0.c.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.airbnb.lottie.ImageAssetDelegate;
import com.airbnb.lottie.LottieImageAsset;
import com.baidu.searchbox.v8engine.WebGLImageLoader;
import com.baidu.swan.apps.storage.PathType;
import d.a.i0.a.g1.f;
import java.io.File;
/* loaded from: classes2.dex */
public class a implements ImageAssetDelegate {

    /* renamed from: a  reason: collision with root package name */
    public String f40677a;

    public a(String str) {
        PathType s = d.a.i0.a.k2.b.s(str);
        if (s == PathType.BD_FILE || s == PathType.RELATIVE) {
            this.f40677a = new File(f.V().I().a(str)).getParent();
        }
    }

    @Override // com.airbnb.lottie.ImageAssetDelegate
    public Bitmap fetchBitmap(LottieImageAsset lottieImageAsset) {
        if (lottieImageAsset == null) {
            return null;
        }
        String fileName = lottieImageAsset.getFileName();
        if (TextUtils.isEmpty(fileName)) {
            return null;
        }
        if (fileName.startsWith(WebGLImageLoader.DATA_URL) && fileName.indexOf("base64,") > 0) {
            try {
                byte[] decode = Base64.decode(fileName.substring(fileName.indexOf(44) + 1), 0);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inScaled = true;
                options.inDensity = 160;
                return BitmapFactory.decodeByteArray(decode, 0, decode.length, options);
            } catch (IllegalArgumentException e2) {
                Log.w("SwanAppAnimationViewAss", "data URL did not have correct base64 format.", e2);
                return null;
            }
        } else if (TextUtils.isEmpty(this.f40677a)) {
            return null;
        } else {
            String dirName = lottieImageAsset.getDirName();
            return BitmapFactory.decodeFile(new File(TextUtils.isEmpty(dirName) ? new File(this.f40677a) : new File(this.f40677a, dirName), lottieImageAsset.getFileName()).getAbsolutePath());
        }
    }
}
