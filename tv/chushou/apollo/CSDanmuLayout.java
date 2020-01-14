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
/* loaded from: classes4.dex */
public class CSDanmuLayout extends DanmakuSurfaceView {
    public static final String[] nTE = {"0xffffffff", "0xff808080", "0xff9825fb", "0xfffc28fc", "0xfffc1368", "0xfffffd38", "0xfffecb2f", "0xfffd9827", "0xfffc6621", "0xfffc361d", "0xff9cfd32", "0xff29fd2e", "0xff2dfffe", "0xff136bfb", "0xff0b24fb"};
    public static final String[] nTF = {Constants.VIA_REPORT_TYPE_JOININ_GROUP, "20", "30"};
    public static final int[] nTG = {5, 1, 4};
    private boolean EA;
    private int borderColor;
    private boolean lFl;
    private Context mContext;
    private String mUserID;
    private float nTC;
    private DanmakuContext nTD;
    private int nTH;
    private tv.chushou.zues.toolkit.richtext.a nTI;
    private a nTJ;
    private b.a nTK;
    private int strokeWidth;

    /* loaded from: classes4.dex */
    public interface a {
        void bD(Object obj);
    }

    public CSDanmuLayout(Context context, tv.chushou.apollo.a aVar, String str) {
        super(context);
        this.mContext = null;
        this.nTC = 1.0f;
        this.nTK = new b.a() { // from class: tv.chushou.apollo.CSDanmuLayout.1
            @Override // master.flame.danmaku.danmaku.model.android.b.a
            public void e(d dVar, boolean z) {
            }

            @Override // master.flame.danmaku.danmaku.model.android.b.a
            public void t(d dVar) {
                if (dVar != null) {
                    dVar.text = null;
                    dVar.tag = null;
                    dVar.nEP = null;
                    dVar.obj = null;
                }
            }
        };
        this.mContext = context.getApplicationContext();
        this.nTD = DanmakuContext.dLa();
        this.mUserID = str;
        this.EA = aVar.isFullScreen;
        this.nTH = aVar.nTB;
        this.lFl = aVar.lFl;
        this.strokeWidth = aVar.strokeWidth;
        this.borderColor = aVar.borderColor;
        if (!this.EA) {
            this.nTC = 0.8f;
        } else {
            this.nTC = 1.0f;
        }
        init();
    }

    public void Sp(String str) {
        this.mUserID = str;
    }

    public void k(String str, ArrayList<RichText> arrayList) {
        if (!h.isEmpty(str)) {
            tv.chushou.apollo.a.a aVar = new tv.chushou.apollo.a.a();
            aVar.mContent = str;
            aVar.mType = "1";
            if (!h.isEmpty(arrayList)) {
                aVar.mContentRichText = arrayList;
            }
            a(aVar, getCurrentTime() + this.nTH, true);
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
        this.nTI = new tv.chushou.apollo.a.b(tv.chushou.zues.utils.a.dip2px(this.mContext, 14.0f), this.mContext);
        HashMap hashMap = new HashMap();
        hashMap.put(1, true);
        this.nTD.j(this.lFl ? 1 : 0, this.strokeWidth).a(new i(), this.nTK).wL(false).F(hashMap);
        setCallback(new c.a() { // from class: tv.chushou.apollo.CSDanmuLayout.2
            @Override // master.flame.danmaku.a.c.a
            public void dKe() {
                CSDanmuLayout.this.start();
            }

            @Override // master.flame.danmaku.a.c.a
            public void b(f fVar) {
            }

            @Override // master.flame.danmaku.a.c.a
            public void j(d dVar) {
            }

            @Override // master.flame.danmaku.a.c.a
            public void dKf() {
            }
        });
        setOnDanmakuClickListener(new f.a() { // from class: tv.chushou.apollo.CSDanmuLayout.3
            @Override // master.flame.danmaku.a.f.a
            public boolean a(l lVar) {
                d dKM = lVar.dKM();
                if (dKM == null || dKM.tag == null || CSDanmuLayout.this.nTJ == null) {
                    return false;
                }
                CSDanmuLayout.this.nTJ.bD(dKM.tag);
                return true;
            }

            @Override // master.flame.danmaku.a.f.a
            public boolean a(master.flame.danmaku.a.f fVar) {
                return false;
            }
        });
        if (!aGB()) {
            a(new master.flame.danmaku.danmaku.a.a() { // from class: tv.chushou.apollo.CSDanmuLayout.4
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // master.flame.danmaku.danmaku.a.a
                /* renamed from: dOq */
                public master.flame.danmaku.danmaku.model.android.d dLw() {
                    return new master.flame.danmaku.danmaku.model.android.d();
                }
            }, this.nTD);
        }
        wP(true);
    }

    public void dOp() {
        wD(true);
    }

    private void a(tv.chushou.apollo.a.a aVar, long j, boolean z) {
        int Sr;
        int i;
        if (aVar != null && !h.isEmpty(aVar.mContent) && this.mContext != null) {
            float Sq = Sq(nTF[1]);
            int Sr2 = Sr(nTE[0]);
            int parseColor = Color.parseColor("#E5000000");
            int i2 = nTG[1];
            if (Sq <= 0.0f) {
                Sq = Sq(nTF[1]);
            }
            float f = Sq * this.nTC;
            String str = aVar.mContent;
            tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
            if (aVar.mType != null) {
                if (aVar.mType.equals("3")) {
                    cVar.a(aVar.mUserNickname + ":  ", new ForegroundColorSpan(this.mContext.getResources().getColor(b.a.apollo_gift_color)));
                    if (a(this.mContext, cVar, aVar.mContentRichText)) {
                        Sr2 = Sr("0xff5959");
                        cVar.append(aVar.mContent);
                    } else {
                        a(this.mContext, cVar, aVar.mContentRichText, ContextCompat.getColor(this.mContext, b.a.apollo_gift_color), -1, null, (int) f, null);
                    }
                } else if (aVar.mType.equals("2")) {
                    if (a(this.mContext, cVar, aVar.mContentRichText)) {
                        Sr2 = Sr("0xff0084");
                        cVar.append(aVar.mContent);
                    } else {
                        if (a(this.mContext, cVar, aVar.mContentRichText, ContextCompat.getColor(this.mContext, b.a.apollo_alarm_color), -1, null, (int) f, null)) {
                            i = 0;
                            Sr = Sr2;
                        } else {
                            Sr = Sr("0xff0084");
                            i = parseColor;
                        }
                        parseColor = i;
                        Sr2 = Sr;
                    }
                } else if (a(this.mContext, cVar, aVar.mContentRichText)) {
                    cVar.append(this.nTI.QL(aVar.mContent));
                } else if (a(this.mContext, cVar, aVar.mContentRichText, ContextCompat.getColor(this.mContext, b.a.apollo_white), -1, null, (int) f, this.nTI)) {
                    parseColor = 0;
                }
            } else if (a(this.mContext, cVar, aVar.mContentRichText)) {
                cVar.append(this.nTI.QL(aVar.mContent));
            } else if (a(this.mContext, cVar, aVar.mContentRichText, ContextCompat.getColor(this.mContext, b.a.apollo_white), -1, null, (int) f, this.nTI)) {
                parseColor = 0;
            }
            int i3 = i2 <= 0 ? 1 : i2;
            d NJ = this.nTD.nGK.NJ(1);
            if (NJ != null) {
                NJ.mxc = true;
                if (this.lFl) {
                    NJ.nEF = parseColor;
                }
                if (i3 == 5 && i3 == 4) {
                    NJ.padding = 20;
                }
                if (z) {
                    NJ.nEH = (byte) 100;
                    NJ.borderColor = this.borderColor;
                } else {
                    NJ.nEH = (byte) 0;
                }
                if ("3".equals(aVar.mType)) {
                    cVar.append("g");
                    String str2 = "danmu" + aVar.nTM.icon;
                    Drawable SL = h.SL(str2);
                    if (SL == null) {
                        SL = h.SN(aVar.nTM.icon);
                        if (SL == null) {
                            SL = null;
                        } else {
                            h.J(str2, SL);
                        }
                    }
                    if (SL == null) {
                        SL = this.mContext.getResources().getDrawable(b.C0795b.apollo_default_gift_color);
                    }
                    if (SL != null) {
                        int intrinsicWidth = SL.getIntrinsicWidth();
                        int intrinsicHeight = SL.getIntrinsicHeight();
                        int a2 = ((int) f) + ((int) tv.chushou.zues.utils.a.a(1, 3.0f, this.mContext));
                        SL.setBounds(0, 0, (intrinsicWidth * a2) / intrinsicHeight, a2);
                        cVar.setSpan(new ImageSpan(SL), cVar.length() - 1, cVar.length(), 33);
                    }
                    NJ.text = cVar;
                    NJ.nEF = 0;
                } else {
                    NJ.text = cVar;
                }
                NJ.setTime(j);
                NJ.aAz = f;
                NJ.textColor = Sr2;
                if (aVar.tag != null) {
                    NJ.setTag(aVar.tag);
                }
                a(NJ);
            }
        }
    }

    private int getDelayTime() {
        return new Random(System.currentTimeMillis()).nextInt(this.nTH);
    }

    private float Sq(String str) {
        return tv.chushou.zues.utils.a.a(2, Math.min(Math.max(h.parseInt(str), h.parseInt(nTF[0])), h.parseInt(nTF[2])), this.mContext);
    }

    private int Sr(String str) {
        if (str == null || !str.startsWith("0x")) {
            return Color.parseColor("#ffffffff");
        }
        return Color.parseColor(str.replace("0x", "#"));
    }

    public void unInit() {
        release();
        this.mContext = null;
        this.nTD = null;
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
                Drawable SL = h.SL(richText.mImage);
                Drawable SN = SL == null ? h.SN(richText.mImage) : SL;
                if (SN != null) {
                    e.d("DanmakuSurfaceView", ": null != drawable");
                    Drawable newDrawable = SN.getConstantState().newDrawable();
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
                        arrayList2.add(new BackgroundColorSpan(Color.parseColor(bR(richText.mBackgroundColor, i2))));
                    }
                    if (!h.isEmpty(richText.mFontColor)) {
                        arrayList2.add(new ForegroundColorSpan(Color.parseColor(bR(richText.mFontColor, i2))));
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
                        r0 = aVar.QL(r0);
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
                    r02 = aVar.QL(r02);
                }
                cVar.a(r02, new ForegroundColorSpan(Color.parseColor(bR("#" + Integer.toHexString(i), i2))));
            }
            i4 = i5 + 1;
        }
        return z || z2;
    }

    private static String bR(String str, @IntRange(from = 0, to = 255) int i) {
        if (!TextUtils.isEmpty(str) && str.length() <= 7 && i >= 0) {
            return str.replace("#", "#" + Integer.toHexString(i));
        }
        return str;
    }

    public void setClickDanmuListener(a aVar) {
        this.nTJ = aVar;
    }
}
