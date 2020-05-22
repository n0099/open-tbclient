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
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ImageView.a;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CameraActivityConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.n.m;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class ImageLoaderPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {
    private static int requestId = -1;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public enum ImageLoadingError {
        Invalid,
        Succeed,
        NoSuchFile,
        NetworkError,
        Canceled
    }

    static /* synthetic */ int access$108() {
        int i = requestId;
        requestId = i + 1;
        return i;
    }

    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        new MethodChannel(flutterPluginBinding.getFlutterEngine().getDartExecutor(), "image_loader_plugin").setMethodCallHandler(new ImageLoaderPlugin());
    }

    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
    }

    public void onMethodCall(MethodCall methodCall, final MethodChannel.Result result) {
        int i;
        Drawable a;
        int i2;
        boolean z;
        if ("loadImage".equals(methodCall.method)) {
            int intValue = ((Integer) methodCall.argument("type")).intValue();
            String str = (String) methodCall.argument("key");
            String str2 = (String) methodCall.argument("themeStr");
            ((Boolean) methodCall.argument("cache")).booleanValue();
            if (aq.isEmpty(str)) {
                result.error("key is empty", "", "");
                return;
            }
            final long currentTimeMillis = System.currentTimeMillis();
            if (intValue == 1) {
                Resources resources = g.jo().getResources();
                if (resources != null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("key", str);
                    hashMap.put("startTime", Long.valueOf(currentTimeMillis));
                    String androidNameFromIos = ResNameTransform.getAndroidNameFromIos(str);
                    int identifier = resources.getIdentifier(androidNameFromIos, "drawable", BdBaseApplication.getInst().getPackageName());
                    boolean z2 = false;
                    if (androidNameFromIos.endsWith("_svg")) {
                        String svgColor = ResNameTransform.getSvgColor(androidNameFromIos);
                        if (svgColor != null) {
                            a = SvgManager.aUV().a(identifier, getResIdBySkin(str2, resources.getIdentifier(svgColor, "color", BdBaseApplication.getInst().getPackageName())), SvgManager.SvgResourceStateType.NORMAL, false);
                        } else {
                            a = SvgManager.aUV().a(identifier, null);
                        }
                        int i3 = 1;
                        if (a != null) {
                            i3 = 2;
                            Bitmap createBitmap = Bitmap.createBitmap(a.getIntrinsicWidth(), a.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                            Canvas canvas = new Canvas(createBitmap);
                            a.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                            a.draw(canvas);
                            if (createBitmap != null) {
                                hashMap.put("step", String.valueOf(3));
                                onResult(ImageLoadingError.Succeed, result, new a(createBitmap, false), hashMap, null);
                                z = true;
                                i2 = 3;
                                boolean z3 = z;
                                i = i2;
                                z2 = z3;
                            }
                        }
                        i2 = i3;
                        z = false;
                        boolean z32 = z;
                        i = i2;
                        z2 = z32;
                    } else {
                        int resIdBySkin = getResIdBySkin(str2, identifier);
                        i = 4;
                        if (resIdBySkin != 0) {
                            i = 5;
                            Bitmap bitMap = getBitMap(resources, resIdBySkin);
                            if (bitMap != null) {
                                hashMap.put("step", String.valueOf(6));
                                onResult(ImageLoadingError.Succeed, result, new a(bitMap, false), hashMap, null);
                                z2 = true;
                                i = 6;
                            }
                        }
                    }
                    if (!z2) {
                        hashMap.put("step", String.valueOf(i));
                        onResult(ImageLoadingError.NoSuchFile, result, null, hashMap, null);
                        if (BdBaseApplication.getInst().isDebugMode()) {
                            UtilHelper.showToast(TbadkCoreApplication.getInst(), "图片找不到:" + str);
                        }
                        BdLog.e("flutter resource in package not found :" + str);
                    }
                }
            } else if (intValue == 2) {
                final HashMap hashMap2 = new HashMap();
                hashMap2.put("key", str);
                hashMap2.put("startTime", Long.valueOf(currentTimeMillis));
                c.kX().a(str, 10, new b<a>() { // from class: com.example.image_loader_plugin.ImageLoaderPlugin.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.e.b
                    public void onLoaded(a aVar, String str3, int i4) {
                        HashMap hashMap3 = null;
                        hashMap2.put("resourceFrom", i4 + "");
                        if (aVar != null) {
                            hashMap2.put("image", String.valueOf(aVar.getImageByte() != null));
                            hashMap2.put("isGif", String.valueOf(aVar.isGif()));
                        } else {
                            hashMap2.put("resource", "null");
                        }
                        if (aVar == null) {
                            ImageLoaderPlugin.this.onResult(ImageLoadingError.NetworkError, result, aVar, hashMap2, null);
                            return;
                        }
                        if (i4 == 3) {
                            ImageLoaderPlugin.access$108();
                            hashMap2.put("requestId", Integer.valueOf(ImageLoaderPlugin.requestId));
                            hashMap3 = new HashMap();
                            hashMap3.put("codecCost", Long.valueOf(aVar.TA.costTime));
                            hashMap3.put("isBundleFile", false);
                            hashMap3.put("netType", j.netTypeNameInLowerCase());
                            hashMap3.put(CameraActivityConfig.KEY_CONTENT_TYPE, String.valueOf(i4));
                            hashMap3.put("loadingCost", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        }
                        ImageLoaderPlugin.this.onResult(ImageLoadingError.Succeed, result, aVar, hashMap2, hashMap3);
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
                        HashMap hashMap3 = new HashMap();
                        hashMap3.put("isCancle", "true");
                        ImageLoaderPlugin.this.onResult(ImageLoadingError.Canceled, result, null, hashMap3, null);
                    }
                }, 0, 0, BdUniqueId.gen(), new Object[0]);
            }
        } else if ("cancel".equals(methodCall.method)) {
            c.kX().k((String) methodCall.arguments(), 10);
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

    private boolean shouldMonitorPerformance(int i) {
        return m.bfI().bfJ() && i % 100 == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onResult(ImageLoadingError imageLoadingError, MethodChannel.Result result, a aVar, HashMap<String, Object> hashMap, HashMap<String, Object> hashMap2) {
        byte[] bArr;
        if (hashMap != null) {
            if (aVar == null) {
                bArr = null;
            } else {
                bArr = aVar.getImageByte();
            }
            if (imageLoadingError == ImageLoadingError.Succeed && bArr == null) {
                imageLoadingError = ImageLoadingError.Invalid;
            }
            if (imageLoadingError == ImageLoadingError.Succeed) {
                HashMap hashMap3 = new HashMap();
                hashMap3.put("key", hashMap.get("key"));
                hashMap3.put(BdStatsConstant.StatsType.ERROR, Integer.valueOf(imageLoadingError.ordinal()));
                hashMap3.put(Config.DEVICE_PART, "android");
                HashMap hashMap4 = new HashMap();
                hashMap4.put("width", Double.valueOf(aVar.getWidth()));
                hashMap4.put("height", Double.valueOf(aVar.getHeight()));
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
            hashMap5.put(BdStatsConstant.StatsType.ERROR, Integer.valueOf(imageLoadingError.ordinal()));
            hashMap5.put(Config.DEVICE_PART, "android");
            hashMap5.put("debugInfo", hashMap.toString());
            if (result != null) {
                result.success(hashMap5);
            }
        }
    }
}
