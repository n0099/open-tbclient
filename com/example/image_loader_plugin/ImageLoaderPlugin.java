package com.example.image_loader_plugin;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.base.g;
import com.baidu.adp.lib.e.b;
import com.baidu.adp.lib.e.c;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ImageView.a;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class ImageLoaderPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public enum ImageLoadingError {
        Invalid,
        Succeed,
        NoSuchFile,
        NetworkError,
        Canceled
    }

    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        new MethodChannel(flutterPluginBinding.getFlutterEngine().getDartExecutor(), "image_loader_plugin").setMethodCallHandler(new ImageLoaderPlugin());
    }

    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMethodCall(MethodCall methodCall, final MethodChannel.Result result) {
        int i;
        Drawable a;
        int i2 = 1;
        boolean z = false;
        if ("loadImage".equals(methodCall.method)) {
            int intValue = ((Integer) methodCall.argument("type")).intValue();
            String str = (String) methodCall.argument("key");
            String str2 = (String) methodCall.argument("themeStr");
            ((Boolean) methodCall.argument("cache")).booleanValue();
            if (aq.isEmpty(str)) {
                result.error("key is empty", "", "");
            } else if (intValue == 1) {
                Resources resources = g.jo().getResources();
                if (resources != null) {
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("key", str);
                    String androidNameFromIos = ResNameTransform.getAndroidNameFromIos(str);
                    int identifier = resources.getIdentifier(androidNameFromIos, "drawable", BdBaseApplication.getInst().getPackageName());
                    if (androidNameFromIos.endsWith("_svg")) {
                        String svgColor = ResNameTransform.getSvgColor(androidNameFromIos);
                        if (svgColor != null) {
                            a = SvgManager.aOU().a(identifier, getResIdBySkin(str2, resources.getIdentifier(svgColor, "color", BdBaseApplication.getInst().getPackageName())), SvgManager.SvgResourceStateType.NORMAL, false);
                        } else {
                            a = SvgManager.aOU().a(identifier, null);
                        }
                        if (a != null) {
                            Bitmap createBitmap = Bitmap.createBitmap(a.getIntrinsicWidth(), a.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                            Canvas canvas = new Canvas(createBitmap);
                            a.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                            a.draw(canvas);
                            if (createBitmap != null) {
                                i = 3;
                                hashMap.put("step", String.valueOf(3));
                                onResult(ImageLoadingError.Succeed, result, new a(createBitmap, false), hashMap);
                                z = true;
                                i2 = i;
                            } else {
                                i2 = 2;
                            }
                        }
                        if (!z) {
                            hashMap.put("step", String.valueOf(i2));
                            onResult(ImageLoadingError.NoSuchFile, result, null, hashMap);
                            if (BdBaseApplication.getInst().isDebugMode()) {
                                UtilHelper.showToast(TbadkCoreApplication.getInst(), "图片找不到:" + str);
                            }
                            BdLog.e("flutter resource in package not found :" + str);
                            return;
                        }
                        return;
                    }
                    int resIdBySkin = getResIdBySkin(str2, identifier);
                    int i3 = 4;
                    if (resIdBySkin != 0) {
                        i3 = 5;
                        Bitmap bitMap = getBitMap(resources, resIdBySkin);
                        if (bitMap != null) {
                            i = 6;
                            hashMap.put("step", String.valueOf(6));
                            onResult(ImageLoadingError.Succeed, result, new a(bitMap, false), hashMap);
                            z = true;
                            i2 = i;
                            if (!z) {
                            }
                        }
                    }
                    i2 = i3;
                    if (!z) {
                    }
                }
            } else if (intValue == 2) {
                c.kV().a(str, 10, new b<a>() { // from class: com.example.image_loader_plugin.ImageLoaderPlugin.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.e.b
                    public void onLoaded(a aVar, String str3, int i4) {
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("key", str3);
                        hashMap2.put("resourceFrom", i4 + "");
                        if (aVar != null) {
                            hashMap2.put("image", String.valueOf(aVar.getImageByte() != null));
                            hashMap2.put("isGif", String.valueOf(aVar.isGif()));
                        } else {
                            hashMap2.put("resource", "null");
                        }
                        if (aVar == null) {
                            ImageLoaderPlugin.this.onResult(ImageLoadingError.NetworkError, result, aVar, hashMap2);
                        } else if (aVar.getImageByte() == null) {
                            ImageLoaderPlugin.this.onResult(ImageLoadingError.Invalid, result, aVar, hashMap2);
                        } else {
                            ImageLoaderPlugin.this.onResult(ImageLoadingError.Succeed, result, aVar, hashMap2);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.e.b
                    public void onProgressUpdate(Object... objArr) {
                        super.onProgressUpdate(objArr);
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.e.b
                    public void onCancelled(String str3) {
                        super.onCancelled(str3);
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("key", str3);
                        hashMap2.put("isCancle", "true");
                        ImageLoaderPlugin.this.onResult(ImageLoadingError.Canceled, result, null, hashMap2);
                    }
                }, 0, 0, BdUniqueId.gen(), new Object[0]);
            }
        } else if ("cancel".equals(methodCall.method)) {
            c.kV().k((String) methodCall.arguments(), 10);
        } else {
            result.notImplemented();
        }
    }

    private int getResIdBySkin(String str, int i) {
        int d;
        int c;
        if (aq.isEmpty(str)) {
            return 0;
        }
        if (ComboPraiseProvider.DIR_PREFIX_NIGHT.equals(str) && (c = am.c(TbadkCoreApplication.getInst().getResources(), i)) > 0) {
            i = c;
        }
        return (!"dark".equals(str) || (d = am.d(TbadkCoreApplication.getInst().getResources(), i)) <= 0) ? i : d;
    }

    private Bitmap getBitMap(Resources resources, int i) {
        if (Build.VERSION.SDK_INT > 21) {
            Drawable drawable = resources.getDrawable(i, null);
            Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        }
        return BitmapFactory.decodeResource(resources, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onResult(ImageLoadingError imageLoadingError, MethodChannel.Result result, a aVar, HashMap<String, String> hashMap) {
        if (hashMap != null) {
            if (imageLoadingError == ImageLoadingError.Succeed) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("key", hashMap.get("key"));
                hashMap2.put(BdStatsConstant.StatsType.ERROR, Integer.valueOf(imageLoadingError.ordinal()));
                hashMap2.put(Config.DEVICE_PART, "android");
                hashMap2.put("debugInfo", hashMap.toString());
                HashMap hashMap3 = new HashMap();
                hashMap3.put("width", Double.valueOf(aVar.getWidth()));
                hashMap3.put("height", Double.valueOf(aVar.getHeight()));
                hashMap3.put("scale", Float.valueOf(1.0f));
                hashMap2.put("imageInfo", hashMap3);
                hashMap2.put("imageData", aVar.getImageByte());
                if (result != null) {
                    result.success(hashMap2);
                    return;
                }
                return;
            }
            HashMap hashMap4 = new HashMap();
            hashMap4.put("key", hashMap.get("key"));
            hashMap4.put(BdStatsConstant.StatsType.ERROR, Integer.valueOf(imageLoadingError.ordinal()));
            hashMap4.put(Config.DEVICE_PART, "android");
            hashMap4.put("debugInfo", hashMap.toString());
            if (result != null) {
                result.success(hashMap4);
            }
        }
    }
}
