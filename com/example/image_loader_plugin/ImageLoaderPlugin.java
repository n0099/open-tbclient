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
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class ImageLoaderPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {
    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        new MethodChannel(flutterPluginBinding.getFlutterEngine().getDartExecutor(), "image_loader_plugin").setMethodCallHandler(new ImageLoaderPlugin());
    }

    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
    }

    public void onMethodCall(MethodCall methodCall, final MethodChannel.Result result) {
        Drawable a;
        if ("loadImage".equals(methodCall.method)) {
            int intValue = ((Integer) methodCall.argument("type")).intValue();
            String str = (String) methodCall.argument("key");
            String str2 = (String) methodCall.argument("themeStr");
            ((Boolean) methodCall.argument("cache")).booleanValue();
            if (aq.isEmpty(str)) {
                result.error("key is empty", "", "");
            } else if (intValue == 1) {
                Resources resources = g.eJ().getResources();
                if (resources != null) {
                    String androidNameFromIos = ResNameTransform.getAndroidNameFromIos(str);
                    int identifier = resources.getIdentifier(androidNameFromIos, "drawable", BdBaseApplication.getInst().getPackageName());
                    if (androidNameFromIos.endsWith("_svg")) {
                        String svgColor = ResNameTransform.getSvgColor(androidNameFromIos);
                        if (svgColor != null) {
                            a = SvgManager.aGC().a(identifier, getResIdBySkin(str2, resources.getIdentifier(svgColor, "color", BdBaseApplication.getInst().getPackageName())), SvgManager.SvgResourceStateType.NORMAL, false);
                        } else {
                            a = SvgManager.aGC().a(identifier, null);
                        }
                        if (a != null) {
                            Bitmap createBitmap = Bitmap.createBitmap(a.getIntrinsicWidth(), a.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                            Canvas canvas = new Canvas(createBitmap);
                            a.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                            a.draw(canvas);
                            if (createBitmap != null) {
                                onResult(result, new a(createBitmap, false), str);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    int resIdBySkin = getResIdBySkin(str2, identifier);
                    if (resIdBySkin != 0) {
                        Bitmap bitMap = getBitMap(resources, resIdBySkin);
                        if (bitMap != null) {
                            onResult(result, new a(bitMap, false), str);
                            return;
                        }
                        return;
                    }
                    result.error("-1", "resource not found :" + str, str);
                    BdLog.e("flutter resource in package not found :" + str);
                }
            } else if (intValue == 2) {
                c.gr().a(str, 10, new b<a>() { // from class: com.example.image_loader_plugin.ImageLoaderPlugin.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.e.b
                    public void onLoaded(a aVar, String str3, int i) {
                        ImageLoaderPlugin.this.onResult(result, aVar, str3);
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
                        result.error("-1", "resource is cancelled :" + str3, str3);
                    }
                }, 0, 0, BdUniqueId.gen(), new Object[0]);
            }
        } else if (UgcUBCUtils.UGC_TIME_CANCEL.equals(methodCall.method)) {
            c.gr().g((String) methodCall.arguments(), 10);
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
    public void onResult(MethodChannel.Result result, a aVar, String str) {
        if (aVar != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("key", str);
            hashMap.put(BdStatsConstant.StatsType.ERROR, 1);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("width", Double.valueOf(aVar.getWidth()));
            hashMap2.put("height", Double.valueOf(aVar.getHeight()));
            hashMap2.put("scale", Float.valueOf(1.0f));
            hashMap.put("imageInfo", hashMap2);
            hashMap.put("imageData", aVar.getImageByte());
            if (result != null) {
                result.success(hashMap);
            }
        }
    }
}
