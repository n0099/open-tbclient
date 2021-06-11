package d.a.n0.w3.r;

import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.switchs.LimitLowQualityPicUploadSwitch;
import com.baidu.tieba.write.view.TitleTipView;
import d.a.m0.b.d;
import d.a.m0.z0.i0;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f66644a = false;

    /* loaded from: classes5.dex */
    public static class a implements InputFilter {

        /* renamed from: e  reason: collision with root package name */
        public InterfaceC1775b f66645e;

        /* renamed from: f  reason: collision with root package name */
        public int f66646f;

        public a(int i2, InterfaceC1775b interfaceC1775b) {
            this.f66646f = i2;
            this.f66645e = interfaceC1775b;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
            if (spanned == null || charSequence == null || (i0.c(spanned.toString()) - (i5 - i4)) + i0.c(charSequence.toString()) <= this.f66646f) {
                return charSequence;
            }
            InterfaceC1775b interfaceC1775b = this.f66645e;
            if (interfaceC1775b != null) {
                interfaceC1775b.a();
            }
            return "";
        }
    }

    /* renamed from: d.a.n0.w3.r.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1775b {
        void a();
    }

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
        return d.a.m0.r.d0.b.j().k("show_write_title_tip_count", 0);
    }

    public static boolean c() {
        return d.I();
    }

    public static void d(int i2, String str) {
        TiebaStatic.log(new StatisticItem("c14021").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", i2).param("obj_param1", str));
    }

    public static void e(WriteData writeData) {
        if (writeData == null || !c() || TextUtils.isEmpty(writeData.getTitle())) {
            return;
        }
        d.a.m0.r.d0.b.j().v("show_write_title_tip_count", b() + 1);
    }

    public static void f() {
        f66644a = true;
    }

    public static void g(TitleTipView titleTipView) {
        if (titleTipView == null) {
            return;
        }
        if (c() && !f66644a && b() <= 0) {
            titleTipView.d();
            f();
            StatisticItem.make("c13996").eventStat();
            return;
        }
        titleTipView.setVisibility(8);
    }
}
