package d.b.h0.b0.g;

import android.graphics.Bitmap;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.searchbox.cloudcontrol.request.CloudControlRequest;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.plugins.MotuPlugin;
/* loaded from: classes3.dex */
public class a extends b {

    /* renamed from: a  reason: collision with root package name */
    public String f49800a = "";

    @Override // d.b.h0.b0.g.b
    public String a() {
        return CloudControlRequest.REQUEST_KEY_FILTER;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, IF] complete} */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 0, expect 1 */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00af, code lost:
        if (r0 != r2) goto L31;
     */
    @Override // d.b.h0.b0.g.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Bitmap b(Bitmap bitmap, boolean z) throws Exception {
        Bitmap bitmap2 = null;
        if (bitmap == null) {
            return null;
        }
        d.b.h0.a0.c.j().h(BitmapHelper.getBitmapSize(bitmap) * 2);
        if ("normal".equals(this.f49800a)) {
            return bitmap;
        }
        MotuPlugin motuPlugin = (MotuPlugin) PluginCenter.getInstance().getMotuClassInstance();
        if (!bitmap.isMutable()) {
            Bitmap.Config config = bitmap.getConfig();
            if (config == null) {
                config = TbConfig.BitmapConfig;
            }
            Bitmap copy = bitmap.copy(config, true);
            if (copy != null) {
                try {
                    if (motuPlugin != null) {
                        try {
                            bitmap2 = motuPlugin.createOneKeyFilterAndApply(TbadkCoreApplication.getInst(), this.f49800a, copy);
                        } catch (IllegalStateException e2) {
                            BdLog.e(e2.toString());
                            e2.printStackTrace();
                        } catch (Throwable th) {
                            BdLog.e(th.toString());
                            th.printStackTrace();
                            if (copy != null && copy != null) {
                            }
                        }
                    }
                } finally {
                    if (copy != null && copy != null) {
                        copy.recycle();
                    }
                }
            }
            if (copy != null) {
            }
        } else if (motuPlugin != null) {
            try {
                bitmap2 = motuPlugin.createOneKeyFilterAndApply(TbadkCoreApplication.getInst().getApp(), this.f49800a, bitmap);
            } catch (Throwable th2) {
                TiebaStatic.imgError(-1008, "motou filter failed: " + th2.toString(), "");
                if (BdLog.isDebugMode()) {
                    th2.printStackTrace();
                }
            }
        }
        if (bitmap2 == null) {
            return bitmap;
        }
        if (z && bitmap2 != bitmap) {
            bitmap.recycle();
        }
        return bitmap2;
    }

    @Override // d.b.h0.b0.g.b
    public void d(String str) {
        if (str == null) {
            return;
        }
        this.f49800a = str;
    }
}
