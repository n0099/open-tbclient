package tv.chushou.apollo;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.IntRange;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import master.flame.danmaku.a.c;
import master.flame.danmaku.a.f;
import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.model.android.b;
import master.flame.danmaku.danmaku.model.android.i;
import master.flame.danmaku.danmaku.model.d;
import master.flame.danmaku.danmaku.model.f;
import master.flame.danmaku.danmaku.model.l;
import master.flame.danmaku.ui.widget.DanmakuSurfaceView;
import tv.chushou.apollo.b;
import tv.chushou.zues.toolkit.richtext.RichText;
import tv.chushou.zues.utils.e;
import tv.chushou.zues.utils.h;
/* loaded from: classes6.dex */
public class CSDanmuLayout extends DanmakuSurfaceView {
    public static final String[] oKL = {"0xffffffff", "0xff808080", "0xff9825fb", "0xfffc28fc", "0xfffc1368", "0xfffffd38", "0xfffecb2f", "0xfffd9827", "0xfffc6621", "0xfffc361d", "0xff9cfd32", "0xff29fd2e", "0xff2dfffe", "0xff136bfb", "0xff0b24fb"};
    public static final String[] oKM = {Constants.VIA_REPORT_TYPE_JOININ_GROUP, "20", "30"};
    public static final int[] oKN = {5, 1, 4};
    private boolean ZD;
    private int borderColor;
    private Context mContext;
    private String mUserID;
    private boolean oKH;
    private float oKJ;
    private DanmakuContext oKK;
    private int oKO;
    private tv.chushou.zues.toolkit.richtext.a oKP;
    private a oKQ;
    private b.a oKR;
    private int strokeWidth;

    /* loaded from: classes6.dex */
    public interface a {
        void bw(Object obj);
    }

    public CSDanmuLayout(Context context, tv.chushou.apollo.a aVar, String str) {
        super(context);
        this.mContext = null;
        this.oKJ = 1.0f;
        this.oKR = new b.a() { // from class: tv.chushou.apollo.CSDanmuLayout.1
            @Override // master.flame.danmaku.danmaku.model.android.b.a
            public void e(d dVar, boolean z) {
            }

            @Override // master.flame.danmaku.danmaku.model.android.b.a
            public void t(d dVar) {
                if (dVar != null) {
                    dVar.text = null;
                    dVar.tag = null;
                    dVar.ovV = null;
                    dVar.obj = null;
                }
            }
        };
        this.mContext = context.getApplicationContext();
        this.oKK = DanmakuContext.eif();
        this.mUserID = str;
        this.ZD = aVar.isFullScreen;
        this.oKO = aVar.oKI;
        this.oKH = aVar.oKH;
        this.strokeWidth = aVar.strokeWidth;
        this.borderColor = aVar.borderColor;
        if (!this.ZD) {
            this.oKJ = 0.8f;
        } else {
            this.oKJ = 1.0f;
        }
        init();
    }

    public void WC(String str) {
        this.mUserID = str;
    }

    public void h(String str, ArrayList<RichText> arrayList) {
        if (!h.isEmpty(str)) {
            tv.chushou.apollo.a.a aVar = new tv.chushou.apollo.a.a();
            aVar.mContent = str;
            aVar.mType = "1";
            if (!h.isEmpty(arrayList)) {
                aVar.mContentRichText = arrayList;
            }
            a(aVar, getCurrentTime() + this.oKO, true);
        }
    }

    public void a(tv.chushou.apollo.a.a aVar) {
        if (aVar != null) {
            if (h.isEmpty(aVar.mType) || (!aVar.mType.equals("3") && !aVar.mType.equals("4"))) {
                if (h.isEmpty(aVar.mType) || !aVar.mType.equals("1") || h.isEmpty(this.mUserID) || !this.mUserID.equals(aVar.mUserID)) {
                    a(aVar, getCurrentTime() + getDelayTime(), false);
                }
            }
        }
    }

    public void init() {
        this.oKP = new tv.chushou.apollo.a.b(tv.chushou.zues.utils.a.dip2px(this.mContext, 14.0f), this.mContext);
        HashMap hashMap = new HashMap();
        hashMap.put(1, true);
        this.oKK.c(this.oKH ? 1 : 0, this.strokeWidth).a(new i(), this.oKR).yT(false).E(hashMap);
        setCallback(new c.a() { // from class: tv.chushou.apollo.CSDanmuLayout.2
            @Override // master.flame.danmaku.a.c.a
            public void ehi() {
                CSDanmuLayout.this.start();
            }

            @Override // master.flame.danmaku.a.c.a
            public void b(f fVar) {
            }

            @Override // master.flame.danmaku.a.c.a
            public void j(d dVar) {
            }

            @Override // master.flame.danmaku.a.c.a
            public void ehj() {
            }
        });
        setOnDanmakuClickListener(new f.a() { // from class: tv.chushou.apollo.CSDanmuLayout.3
            @Override // master.flame.danmaku.a.f.a
            public boolean a(l lVar) {
                d ehR = lVar.ehR();
                if (ehR == null || ehR.tag == null || CSDanmuLayout.this.oKQ == null) {
                    return false;
                }
                CSDanmuLayout.this.oKQ.bw(ehR.tag);
                return true;
            }

            @Override // master.flame.danmaku.a.f.a
            public boolean a(master.flame.danmaku.a.f fVar) {
                return false;
            }
        });
        if (!isPrepared()) {
            a(new master.flame.danmaku.danmaku.a.a() { // from class: tv.chushou.apollo.CSDanmuLayout.4
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // master.flame.danmaku.danmaku.a.a
                /* renamed from: elw */
                public master.flame.danmaku.danmaku.model.android.d eiB() {
                    return new master.flame.danmaku.danmaku.model.android.d();
                }
            }, this.oKK);
        }
        yX(true);
    }

    public void elv() {
        yL(true);
    }

    private void a(tv.chushou.apollo.a.a aVar, long j, boolean z) {
        int WE;
        int i;
        if (aVar != null && !h.isEmpty(aVar.mContent) && this.mContext != null) {
            float WD = WD(oKM[1]);
            int WE2 = WE(oKL[0]);
            int parseColor = Color.parseColor("#E5000000");
            int i2 = oKN[1];
            if (WD <= 0.0f) {
                WD = WD(oKM[1]);
            }
            float f = WD * this.oKJ;
            String str = aVar.mContent;
            tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
            if (aVar.mType != null) {
                if (aVar.mType.equals("3")) {
                    cVar.a(aVar.mUserNickname + ":  ", new ForegroundColorSpan(this.mContext.getResources().getColor(b.a.apollo_gift_color)));
                    if (a(this.mContext, cVar, aVar.mContentRichText)) {
                        WE2 = WE("0xff5959");
                        cVar.append(aVar.mContent);
                    } else {
                        a(this.mContext, cVar, aVar.mContentRichText, ContextCompat.getColor(this.mContext, b.a.apollo_gift_color), -1, null, (int) f, null);
                    }
                } else if (aVar.mType.equals("2")) {
                    if (a(this.mContext, cVar, aVar.mContentRichText)) {
                        WE2 = WE("0xff0084");
                        cVar.append(aVar.mContent);
                    } else {
                        if (a(this.mContext, cVar, aVar.mContentRichText, ContextCompat.getColor(this.mContext, b.a.apollo_alarm_color), -1, null, (int) f, null)) {
                            i = 0;
                            WE = WE2;
                        } else {
                            WE = WE("0xff0084");
                            i = parseColor;
                        }
                        parseColor = i;
                        WE2 = WE;
                    }
                } else if (a(this.mContext, cVar, aVar.mContentRichText)) {
                    cVar.append(this.oKP.Vd(aVar.mContent));
                } else if (a(this.mContext, cVar, aVar.mContentRichText, ContextCompat.getColor(this.mContext, b.a.apollo_white), -1, null, (int) f, this.oKP)) {
                    parseColor = 0;
                }
            } else if (a(this.mContext, cVar, aVar.mContentRichText)) {
                cVar.append(this.oKP.Vd(aVar.mContent));
            } else if (a(this.mContext, cVar, aVar.mContentRichText, ContextCompat.getColor(this.mContext, b.a.apollo_white), -1, null, (int) f, this.oKP)) {
                parseColor = 0;
            }
            int i3 = i2 <= 0 ? 1 : i2;
            d Od = this.oKK.oxR.Od(1);
            if (Od != null) {
                Od.kkG = true;
                if (this.oKH) {
                    Od.ovM = parseColor;
                }
                if (i3 == 5 && i3 == 4) {
                    Od.padding = 20;
                }
                if (z) {
                    Od.ovN = (byte) 100;
                    Od.borderColor = this.borderColor;
                } else {
                    Od.ovN = (byte) 0;
                }
                if ("3".equals(aVar.mType)) {
                    cVar.append(IXAdRequestInfo.GPS);
                    String str2 = "danmu" + aVar.oKT.icon;
                    Drawable WY = h.WY(str2);
                    if (WY == null) {
                        WY = h.Xa(aVar.oKT.icon);
                        if (WY == null) {
                            WY = null;
                        } else {
                            h.P(str2, WY);
                        }
                    }
                    if (WY == null) {
                        WY = this.mContext.getResources().getDrawable(b.C1004b.apollo_default_gift_color);
                    }
                    if (WY != null) {
                        int intrinsicWidth = WY.getIntrinsicWidth();
                        int intrinsicHeight = WY.getIntrinsicHeight();
                        int a2 = ((int) f) + ((int) tv.chushou.zues.utils.a.a(1, 3.0f, this.mContext));
                        WY.setBounds(0, 0, (intrinsicWidth * a2) / intrinsicHeight, a2);
                        cVar.setSpan(new ImageSpan(WY), cVar.length() - 1, cVar.length(), 33);
                    }
                    Od.text = cVar;
                    Od.ovM = 0;
                } else {
                    Od.text = cVar;
                }
                Od.setTime(j);
                Od.btB = f;
                Od.textColor = WE2;
                if (aVar.tag != null) {
                    Od.setTag(aVar.tag);
                }
                a(Od);
            }
        }
    }

    private int getDelayTime() {
        return new Random(System.currentTimeMillis()).nextInt(this.oKO);
    }

    private float WD(String str) {
        return tv.chushou.zues.utils.a.a(2, Math.min(Math.max(h.parseInt(str), h.parseInt(oKM[0])), h.parseInt(oKM[2])), this.mContext);
    }

    private int WE(String str) {
        if (str == null || !str.startsWith("0x")) {
            return Color.parseColor("#ffffffff");
        }
        return Color.parseColor(str.replace("0x", "#"));
    }

    public void unInit() {
        release();
        this.mContext = null;
        this.oKK = null;
    }

    public static boolean a(Context context, tv.chushou.zues.widget.a.c cVar, ArrayList<RichText> arrayList) {
        return context == null || cVar == null || h.isEmpty(arrayList);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:32:0x00cf */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:53:0x013a */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r0v14, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v15, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r0v16, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r0v31 */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r14v0, types: [tv.chushou.zues.toolkit.richtext.a] */
    /* JADX WARN: Type inference failed for: r8v0, types: [tv.chushou.zues.widget.a.c] */
    public static boolean a(Context context, tv.chushou.zues.widget.a.c cVar, ArrayList<RichText> arrayList, @ColorInt int i, @IntRange(from = -1, to = 255) int i2, String str, int i3, tv.chushou.zues.toolkit.richtext.a aVar) {
        int i4 = 0;
        boolean z = false;
        boolean z2 = false;
        while (true) {
            int i5 = i4;
            if (i5 >= arrayList.size()) {
                break;
            }
            RichText richText = arrayList.get(i5);
            if (richText.mType == 2) {
                Drawable WY = h.WY(richText.mImage);
                Drawable Xa = WY == null ? h.Xa(richText.mImage) : WY;
                if (Xa != null) {
                    e.d("DanmakuSurfaceView", ": null != drawable");
                    Drawable newDrawable = Xa.getConstantState().newDrawable();
                    int intrinsicWidth = newDrawable.getIntrinsicWidth();
                    int intrinsicHeight = newDrawable.getIntrinsicHeight();
                    int a2 = ((int) tv.chushou.zues.utils.a.a(1, 3.0f, context)) + i3;
                    newDrawable.setBounds(0, 0, (intrinsicWidth * a2) / intrinsicHeight, a2);
                    cVar.a("", new tv.chushou.zues.widget.a.e(newDrawable));
                }
                z = true;
            } else if (richText.mType == 1) {
                if (!h.isEmpty(richText.mContent)) {
                    ArrayList arrayList2 = new ArrayList();
                    if (!h.isEmpty(richText.mBackgroundColor)) {
                        arrayList2.add(new BackgroundColorSpan(Color.parseColor(bT(richText.mBackgroundColor, i2))));
                    }
                    if (!h.isEmpty(richText.mFontColor)) {
                        arrayList2.add(new ForegroundColorSpan(Color.parseColor(bT(richText.mFontColor, i2))));
                    }
                    if (richText.mFontStyle == 1) {
                        arrayList2.add(new StyleSpan(1));
                    } else if (richText.mFontStyle == 2) {
                        arrayList2.add(new TypefaceSpan("monospace"));
                        arrayList2.add(new StyleSpan(2));
                    } else if (richText.mFontStyle == 4) {
                        arrayList2.add(new UnderlineSpan());
                    } else {
                        arrayList2.add(new StyleSpan(0));
                    }
                    String str2 = richText.mContent;
                    ?? r0 = str2;
                    if (!h.isEmpty(str)) {
                        boolean endsWith = str2.endsWith(str);
                        r0 = str2;
                        if (!endsWith) {
                            r0 = str2 + str;
                        }
                    }
                    if (aVar != 0) {
                        r0 = aVar.Vd(r0);
                    }
                    if (arrayList2.size() > 0) {
                        cVar.a(r0, arrayList2);
                    } else {
                        cVar.append(r0);
                    }
                }
                z2 = true;
            } else if (!h.isEmpty(richText.mContent)) {
                String str3 = richText.mContent;
                ?? r02 = str3;
                if (!h.isEmpty(str)) {
                    boolean endsWith2 = str3.endsWith(str);
                    r02 = str3;
                    if (!endsWith2) {
                        r02 = str3 + str;
                    }
                }
                if (aVar != 0) {
                    r02 = aVar.Vd(r02);
                }
                cVar.a(r02, new ForegroundColorSpan(Color.parseColor(bT("#" + Integer.toHexString(i), i2))));
            }
            i4 = i5 + 1;
        }
        return z || z2;
    }

    private static String bT(String str, @IntRange(from = 0, to = 255) int i) {
        if (!TextUtils.isEmpty(str) && str.length() <= 7 && i >= 0) {
            return str.replace("#", "#" + Integer.toHexString(i));
        }
        return str;
    }

    public void setClickDanmuListener(a aVar) {
        this.oKQ = aVar;
    }
}
