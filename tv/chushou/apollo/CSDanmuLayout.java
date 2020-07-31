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
/* loaded from: classes6.dex */
public class CSDanmuLayout extends DanmakuSurfaceView {
    public static final String[] oqP = {"0xffffffff", "0xff808080", "0xff9825fb", "0xfffc28fc", "0xfffc1368", "0xfffffd38", "0xfffecb2f", "0xfffd9827", "0xfffc6621", "0xfffc361d", "0xff9cfd32", "0xff29fd2e", "0xff2dfffe", "0xff136bfb", "0xff0b24fb"};
    public static final String[] oqQ = {Constants.VIA_REPORT_TYPE_JOININ_GROUP, "20", "30"};
    public static final int[] oqR = {5, 1, 4};
    private boolean YX;
    private int borderColor;
    private Context mContext;
    private String mUserID;
    private boolean oqL;
    private float oqN;
    private DanmakuContext oqO;
    private int oqS;
    private tv.chushou.zues.toolkit.richtext.a oqT;
    private a oqU;
    private b.a oqV;
    private int strokeWidth;

    /* loaded from: classes6.dex */
    public interface a {
        void bu(Object obj);
    }

    public CSDanmuLayout(Context context, tv.chushou.apollo.a aVar, String str) {
        super(context);
        this.mContext = null;
        this.oqN = 1.0f;
        this.oqV = new b.a() { // from class: tv.chushou.apollo.CSDanmuLayout.1
            @Override // master.flame.danmaku.danmaku.model.android.b.a
            public void e(d dVar, boolean z) {
            }

            @Override // master.flame.danmaku.danmaku.model.android.b.a
            public void t(d dVar) {
                if (dVar != null) {
                    dVar.text = null;
                    dVar.tag = null;
                    dVar.obV = null;
                    dVar.obj = null;
                }
            }
        };
        this.mContext = context.getApplicationContext();
        this.oqO = DanmakuContext.dWb();
        this.mUserID = str;
        this.YX = aVar.isFullScreen;
        this.oqS = aVar.oqM;
        this.oqL = aVar.oqL;
        this.strokeWidth = aVar.strokeWidth;
        this.borderColor = aVar.borderColor;
        if (!this.YX) {
            this.oqN = 0.8f;
        } else {
            this.oqN = 1.0f;
        }
        init();
    }

    public void Ty(String str) {
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
            a(aVar, getCurrentTime() + this.oqS, true);
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
        this.oqT = new tv.chushou.apollo.a.b(tv.chushou.zues.utils.a.dip2px(this.mContext, 14.0f), this.mContext);
        HashMap hashMap = new HashMap();
        hashMap.put(1, true);
        this.oqO.c(this.oqL ? 1 : 0, this.strokeWidth).a(new i(), this.oqV).yb(false).E(hashMap);
        setCallback(new c.a() { // from class: tv.chushou.apollo.CSDanmuLayout.2
            @Override // master.flame.danmaku.a.c.a
            public void dVf() {
                CSDanmuLayout.this.start();
            }

            @Override // master.flame.danmaku.a.c.a
            public void b(f fVar) {
            }

            @Override // master.flame.danmaku.a.c.a
            public void j(d dVar) {
            }

            @Override // master.flame.danmaku.a.c.a
            public void dVg() {
            }
        });
        setOnDanmakuClickListener(new f.a() { // from class: tv.chushou.apollo.CSDanmuLayout.3
            @Override // master.flame.danmaku.a.f.a
            public boolean a(l lVar) {
                d dVN = lVar.dVN();
                if (dVN == null || dVN.tag == null || CSDanmuLayout.this.oqU == null) {
                    return false;
                }
                CSDanmuLayout.this.oqU.bu(dVN.tag);
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
                /* renamed from: dZr */
                public master.flame.danmaku.danmaku.model.android.d dWx() {
                    return new master.flame.danmaku.danmaku.model.android.d();
                }
            }, this.oqO);
        }
        yf(true);
    }

    public void dZq() {
        xT(true);
    }

    private void a(tv.chushou.apollo.a.a aVar, long j, boolean z) {
        int TA;
        int i;
        if (aVar != null && !h.isEmpty(aVar.mContent) && this.mContext != null) {
            float Tz = Tz(oqQ[1]);
            int TA2 = TA(oqP[0]);
            int parseColor = Color.parseColor("#E5000000");
            int i2 = oqR[1];
            if (Tz <= 0.0f) {
                Tz = Tz(oqQ[1]);
            }
            float f = Tz * this.oqN;
            String str = aVar.mContent;
            tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
            if (aVar.mType != null) {
                if (aVar.mType.equals("3")) {
                    cVar.a(aVar.mUserNickname + ":  ", new ForegroundColorSpan(this.mContext.getResources().getColor(b.a.apollo_gift_color)));
                    if (a(this.mContext, cVar, aVar.mContentRichText)) {
                        TA2 = TA("0xff5959");
                        cVar.append(aVar.mContent);
                    } else {
                        a(this.mContext, cVar, aVar.mContentRichText, ContextCompat.getColor(this.mContext, b.a.apollo_gift_color), -1, null, (int) f, null);
                    }
                } else if (aVar.mType.equals("2")) {
                    if (a(this.mContext, cVar, aVar.mContentRichText)) {
                        TA2 = TA("0xff0084");
                        cVar.append(aVar.mContent);
                    } else {
                        if (a(this.mContext, cVar, aVar.mContentRichText, ContextCompat.getColor(this.mContext, b.a.apollo_alarm_color), -1, null, (int) f, null)) {
                            i = 0;
                            TA = TA2;
                        } else {
                            TA = TA("0xff0084");
                            i = parseColor;
                        }
                        parseColor = i;
                        TA2 = TA;
                    }
                } else if (a(this.mContext, cVar, aVar.mContentRichText)) {
                    cVar.append(this.oqT.RZ(aVar.mContent));
                } else if (a(this.mContext, cVar, aVar.mContentRichText, ContextCompat.getColor(this.mContext, b.a.apollo_white), -1, null, (int) f, this.oqT)) {
                    parseColor = 0;
                }
            } else if (a(this.mContext, cVar, aVar.mContentRichText)) {
                cVar.append(this.oqT.RZ(aVar.mContent));
            } else if (a(this.mContext, cVar, aVar.mContentRichText, ContextCompat.getColor(this.mContext, b.a.apollo_white), -1, null, (int) f, this.oqT)) {
                parseColor = 0;
            }
            int i3 = i2 <= 0 ? 1 : i2;
            d LA = this.oqO.odS.LA(1);
            if (LA != null) {
                LA.jVi = true;
                if (this.oqL) {
                    LA.obM = parseColor;
                }
                if (i3 == 5 && i3 == 4) {
                    LA.padding = 20;
                }
                if (z) {
                    LA.obN = (byte) 100;
                    LA.borderColor = this.borderColor;
                } else {
                    LA.obN = (byte) 0;
                }
                if ("3".equals(aVar.mType)) {
                    cVar.append("g");
                    String str2 = "danmu" + aVar.oqX.icon;
                    Drawable TU = h.TU(str2);
                    if (TU == null) {
                        TU = h.TW(aVar.oqX.icon);
                        if (TU == null) {
                            TU = null;
                        } else {
                            h.Q(str2, TU);
                        }
                    }
                    if (TU == null) {
                        TU = this.mContext.getResources().getDrawable(b.C0946b.apollo_default_gift_color);
                    }
                    if (TU != null) {
                        int intrinsicWidth = TU.getIntrinsicWidth();
                        int intrinsicHeight = TU.getIntrinsicHeight();
                        int a2 = ((int) f) + ((int) tv.chushou.zues.utils.a.a(1, 3.0f, this.mContext));
                        TU.setBounds(0, 0, (intrinsicWidth * a2) / intrinsicHeight, a2);
                        cVar.setSpan(new ImageSpan(TU), cVar.length() - 1, cVar.length(), 33);
                    }
                    LA.text = cVar;
                    LA.obM = 0;
                } else {
                    LA.text = cVar;
                }
                LA.setTime(j);
                LA.bnP = f;
                LA.textColor = TA2;
                if (aVar.tag != null) {
                    LA.setTag(aVar.tag);
                }
                a(LA);
            }
        }
    }

    private int getDelayTime() {
        return new Random(System.currentTimeMillis()).nextInt(this.oqS);
    }

    private float Tz(String str) {
        return tv.chushou.zues.utils.a.a(2, Math.min(Math.max(h.parseInt(str), h.parseInt(oqQ[0])), h.parseInt(oqQ[2])), this.mContext);
    }

    private int TA(String str) {
        if (str == null || !str.startsWith("0x")) {
            return Color.parseColor("#ffffffff");
        }
        return Color.parseColor(str.replace("0x", "#"));
    }

    public void unInit() {
        release();
        this.mContext = null;
        this.oqO = null;
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
                Drawable TU = h.TU(richText.mImage);
                Drawable TW = TU == null ? h.TW(richText.mImage) : TU;
                if (TW != null) {
                    e.d("DanmakuSurfaceView", ": null != drawable");
                    Drawable newDrawable = TW.getConstantState().newDrawable();
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
                        arrayList2.add(new BackgroundColorSpan(Color.parseColor(bO(richText.mBackgroundColor, i2))));
                    }
                    if (!h.isEmpty(richText.mFontColor)) {
                        arrayList2.add(new ForegroundColorSpan(Color.parseColor(bO(richText.mFontColor, i2))));
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
                        r0 = aVar.RZ(r0);
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
                    r02 = aVar.RZ(r02);
                }
                cVar.a(r02, new ForegroundColorSpan(Color.parseColor(bO("#" + Integer.toHexString(i), i2))));
            }
            i4 = i5 + 1;
        }
        return z || z2;
    }

    private static String bO(String str, @IntRange(from = 0, to = 255) int i) {
        if (!TextUtils.isEmpty(str) && str.length() <= 7 && i >= 0) {
            return str.replace("#", "#" + Integer.toHexString(i));
        }
        return str;
    }

    public void setClickDanmuListener(a aVar) {
        this.oqU = aVar;
    }
}
