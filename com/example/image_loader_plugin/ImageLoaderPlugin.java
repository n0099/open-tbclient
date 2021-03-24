package com.example.image_loader_plugin;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.sapi2.SapiOptions;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import d.b.b.a.h;
import d.b.b.e.l.c;
import d.b.b.e.l.d;
import d.b.b.e.p.j;
import d.b.b.e.p.k;
import d.b.b.j.d.a;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class ImageLoaderPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {
    public static int requestId = -1;

    /* loaded from: classes6.dex */
    public enum ImageLoadingError {
        Invalid,
        Succeed,
        NoSuchFile,
        NetworkError,
        Canceled
    }

    public static /* synthetic */ int access$108() {
        int i = requestId;
        requestId = i + 1;
        return i;
    }

    public final Bitmap getBitMap(Resources resources, int i) {
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

    public final int getResIdBySkin(String str, int i) {
        int darkResourceId;
        int nightResouceId;
        if (k.isEmpty(str)) {
            return 0;
        }
        if (SkinManager.SKIN_TYPE_STR_NIGHT.equals(str) && (nightResouceId = SkinManager.getNightResouceId(TbadkCoreApplication.getInst().getResources(), i)) > 0) {
            i = nightResouceId;
        }
        return (!"dark".equals(str) || (darkResourceId = SkinManager.getDarkResourceId(TbadkCoreApplication.getInst().getResources(), i)) <= 0) ? i : darkResourceId;
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "image_loader_plugin").setMethodCallHandler(new ImageLoaderPlugin());
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, final MethodChannel.Result result) {
        Drawable maskDrawable;
        int intValue;
        int i;
        int intValue2;
        if ("loadImage".equals(methodCall.method)) {
            int intValue3 = ((Integer) methodCall.argument("type")).intValue();
            String str = (String) methodCall.argument("key");
            String str2 = (String) methodCall.argument("themeStr");
            boolean booleanValue = ((Boolean) methodCall.argument("isSvg")).booleanValue();
            ((Boolean) methodCall.argument(SapiOptions.q)).booleanValue();
            final boolean booleanValue2 = ((Boolean) methodCall.argument("preload")).booleanValue();
            if (k.isEmpty(str)) {
                result.error("key is empty", "", "");
                return;
            }
            final long currentTimeMillis = System.currentTimeMillis();
            int i2 = 2;
            boolean z = true;
            if (intValue3 != 1) {
                if (intValue3 == 2) {
                    final HashMap hashMap = new HashMap();
                    hashMap.put("key", str);
                    hashMap.put("startTime", Long.valueOf(currentTimeMillis));
                    d.h().k(str, 44, new c<a>() { // from class: com.example.image_loader_plugin.ImageLoaderPlugin.1
                        @Override // d.b.b.e.l.c
                        public void onCancelled(String str3) {
                            super.onCancelled(str3);
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put("isCancle", "true");
                            ImageLoaderPlugin.this.onResult(ImageLoadingError.Canceled, result, null, hashMap2, null);
                        }

                        @Override // d.b.b.e.l.c
                        public void onProgressUpdate(Object... objArr) {
                            super.onProgressUpdate(objArr);
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // d.b.b.e.l.c
                        public void onLoaded(a aVar, String str3, int i3) {
                            if (booleanValue2) {
                                return;
                            }
                            HashMap hashMap2 = hashMap;
                            hashMap2.put("resourceFrom", i3 + "");
                            if (aVar != null) {
                                hashMap.put("isGif", String.valueOf(aVar.t()));
                            } else {
                                hashMap.put("resource", StringUtil.NULL_STRING);
                            }
                            if (aVar == null) {
                                ImageLoaderPlugin.this.onResult(ImageLoadingError.NetworkError, result, aVar, hashMap, null);
                                return;
                            }
                            HashMap hashMap3 = null;
                            if (i3 == 3) {
                                ImageLoaderPlugin.access$108();
                                hashMap.put("requestId", Integer.valueOf(ImageLoaderPlugin.requestId));
                                hashMap3 = new HashMap();
                                hashMap3.put("isBundleFile", Boolean.FALSE);
                                hashMap3.put("netType", j.J());
                                hashMap3.put("contentType", String.valueOf(i3));
                                hashMap3.put("loadingCost", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            }
                            ImageLoaderPlugin.this.onResult(ImageLoadingError.Succeed, result, aVar, hashMap, hashMap3);
                        }
                    }, 0, 0, BdUniqueId.gen(), new Object[0]);
                    return;
                }
                return;
            }
            Resources b2 = h.a().b();
            if (b2 == null) {
                return;
            }
            HashMap<String, Object> hashMap2 = new HashMap<>();
            hashMap2.put("key", str);
            hashMap2.put("startTime", Long.valueOf(currentTimeMillis));
            String androidNameFromIos = ResNameTransform.getAndroidNameFromIos(str);
            int identifier = b2.getIdentifier(androidNameFromIos, "drawable", BdBaseApplication.getInst().getPackageName());
            if (androidNameFromIos.contains("_mask_") || androidNameFromIos.contains("_pure_")) {
                if (booleanValue) {
                    if (methodCall.hasArgument("patternColor")) {
                        if (methodCall.argument("patternColor") instanceof Integer) {
                            intValue2 = ((Integer) methodCall.argument("patternColor")).intValue();
                        } else {
                            intValue2 = methodCall.argument("patternColor") instanceof Long ? ((Long) methodCall.argument("patternColor")).intValue() : 0;
                        }
                        maskDrawable = SvgManager.getInstance().getPureDrawableWithColorValue(identifier, intValue2, SvgManager.SvgResourceStateType.NORMAL);
                    } else {
                        maskDrawable = SvgManager.getInstance().getMaskDrawable(identifier, null);
                    }
                } else if (methodCall.hasArgument("patternColor")) {
                    if (methodCall.argument("patternColor") instanceof Integer) {
                        intValue = ((Integer) methodCall.argument("patternColor")).intValue();
                    } else {
                        intValue = methodCall.argument("patternColor") instanceof Long ? ((Long) methodCall.argument("patternColor")).intValue() : 0;
                    }
                    maskDrawable = WebPManager.getPureDrawable(identifier, intValue, WebPManager.ResourceStateType.NORMAL);
                } else {
                    maskDrawable = WebPManager.getMaskDrawable(identifier, null);
                }
                if (maskDrawable != null) {
                    Bitmap createBitmap = Bitmap.createBitmap(maskDrawable.getIntrinsicWidth(), maskDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas = new Canvas(createBitmap);
                    maskDrawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                    maskDrawable.draw(canvas);
                    if (createBitmap != null) {
                        i2 = 3;
                        hashMap2.put("step", String.valueOf(3));
                        onResult(ImageLoadingError.Succeed, result, new a(createBitmap, false), hashMap2, null);
                        i = i2;
                    }
                } else {
                    i2 = 1;
                }
                z = false;
                i = i2;
            } else {
                int resIdBySkin = getResIdBySkin(str2, identifier);
                i = 4;
                if (resIdBySkin != 0) {
                    i = 5;
                    Bitmap bitMap = getBitMap(b2, resIdBySkin);
                    if (bitMap != null) {
                        hashMap2.put("step", String.valueOf(6));
                        onResult(ImageLoadingError.Succeed, result, new a(bitMap, false), hashMap2, null);
                        i = 6;
                    }
                }
                z = false;
            }
            if (z) {
                return;
            }
            hashMap2.put("step", String.valueOf(i));
            onResult(ImageLoadingError.NoSuchFile, result, null, hashMap2, null);
            if (BdBaseApplication.getInst().isDebugMode()) {
                TbadkCoreApplication inst = TbadkCoreApplication.getInst();
                UtilHelper.showToast(inst, "图片找不到:" + str);
            }
            BdLog.e("flutter resource in package not found :" + str);
        } else if (QueryResponse.Options.CANCEL.equals(methodCall.method)) {
            d.h().c((String) methodCall.arguments(), 44);
        } else {
            result.notImplemented();
        }
    }

    public final void onResult(ImageLoadingError imageLoadingError, MethodChannel.Result result, a aVar, HashMap<String, Object> hashMap, HashMap<String, Object> hashMap2) {
        if (hashMap == null) {
            return;
        }
        byte[] bArr = null;
        if (aVar != null && (bArr = aVar.k()) == null && aVar.w()) {
            bArr = aVar.n();
        }
        if (imageLoadingError == ImageLoadingError.Succeed && bArr == null) {
            imageLoadingError = ImageLoadingError.Invalid;
        }
        if (imageLoadingError == ImageLoadingError.Succeed) {
            HashMap hashMap3 = new HashMap();
            hashMap3.put("key", hashMap.get("key"));
            hashMap3.put("error", Integer.valueOf(imageLoadingError.ordinal()));
            hashMap3.put("device", "android");
            HashMap hashMap4 = new HashMap();
            hashMap4.put("scale", Float.valueOf(1.0f));
            hashMap3.put("imageInfo", hashMap4);
            hashMap3.put("imageData", bArr);
            hashMap3.put("debugInfo", hashMap.toString());
            if (hashMap.containsKey("requestId") && shouldMonitorPerformance(((Integer) hashMap.get("requestId")).intValue()) && hashMap2 != null) {
                if (bArr != null) {
                    hashMap2.put("imageDataSize", Integer.valueOf(bArr.length));
                }
                hashMap2.put("sendTime", Long.valueOf(System.currentTimeMillis()));
                hashMap3.put("performance", hashMap2);
            }
            if (result != null) {
                result.success(hashMap3);
                return;
            }
            return;
        }
        HashMap hashMap5 = new HashMap();
        hashMap5.put("key", hashMap.get("key"));
        hashMap5.put("error", Integer.valueOf(imageLoadingError.ordinal()));
        hashMap5.put("device", "android");
        hashMap5.put("debugInfo", hashMap.toString());
        if (result != null) {
            result.success(hashMap5);
        }
    }

    public final boolean shouldMonitorPerformance(int i) {
        return d.b.h0.m0.k.d().g() && i % 100 == 0;
    }
}
