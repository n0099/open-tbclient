package tv.chushou.apollo;

import com.tencent.connect.common.Constants;
import java.util.Random;
import master.flame.danmaku.ui.widget.DanmakuTextureView;
/* loaded from: classes6.dex */
public class CSVideoPlayDanmuLayout extends DanmakuTextureView {
    public static final String[] oqR = {"0xffffffff", "0xff808080", "0xff9825fb", "0xfffc28fc", "0xfffc1368", "0xfffffd38", "0xfffecb2f", "0xfffd9827", "0xfffc6621", "0xfffc361d", "0xff9cfd32", "0xff29fd2e", "0xff2dfffe", "0xff136bfb", "0xff0b24fb"};
    public static final String[] oqS = {Constants.VIA_REPORT_TYPE_JOININ_GROUP, "20", "30"};
    public static final int[] oqT = {5, 1, 4};
    private int oqU;

    private int getDelayTime() {
        return new Random(System.currentTimeMillis()).nextInt(this.oqU);
    }
}
