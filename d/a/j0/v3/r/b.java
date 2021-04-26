package d.a.j0.v3.r;

import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.switchs.LimitLowQualityPicUploadSwitch;
import com.baidu.tieba.write.view.TitleTipView;
import d.a.i0.b.d;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f62098a = false;

    public static boolean a(ImageFileInfo imageFileInfo) {
        String filePath;
        if (!LimitLowQualityPicUploadSwitch.isOff() && imageFileInfo != null && !imageFileInfo.isGif() && (filePath = imageFileInfo.getFilePath()) != null) {
            long fileSize = FileHelper.getFileSize(filePath);
            if (fileSize < 5120) {
                d(1, "" + fileSize);
                return true;
            }
            int[] imageFileWH = FileHelper.getImageFileWH(filePath);
            if (imageFileWH[0] < 100 || imageFileWH[1] < 100) {
                d(2, imageFileWH[0] + "*" + imageFileWH[1]);
                return true;
            }
        }
        return false;
    }

    public static int b() {
        return d.a.i0.r.d0.b.j().k("show_write_title_tip_count", 0);
    }

    public static boolean c() {
        return d.H();
    }

    public static void d(int i2, String str) {
        TiebaStatic.log(new StatisticItem("c14021").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", i2).param("obj_param1", str));
    }

    public static void e(WriteData writeData) {
        if (writeData == null || !c() || TextUtils.isEmpty(writeData.getTitle())) {
            return;
        }
        d.a.i0.r.d0.b.j().v("show_write_title_tip_count", b() + 1);
    }

    public static void f() {
        f62098a = true;
    }

    public static void g(TitleTipView titleTipView) {
        if (titleTipView == null) {
            return;
        }
        if (c() && !f62098a && b() <= 0) {
            titleTipView.d();
            f();
            StatisticItem.make("c13996").eventStat();
            return;
        }
        titleTipView.setVisibility(8);
    }
}
