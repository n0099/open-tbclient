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
/* loaded from: classes5.dex */
public class CSDanmuLayout extends DanmakuSurfaceView {
    public static final String[] nMp = {"0xffffffff", "0xff808080", "0xff9825fb", "0xfffc28fc", "0xfffc1368", "0xfffffd38", "0xfffecb2f", "0xfffd9827", "0xfffc6621", "0xfffc361d", "0xff9cfd32", "0xff29fd2e", "0xff2dfffe", "0xff136bfb", "0xff0b24fb"};
    public static final String[] nMq = {Constants.VIA_REPORT_TYPE_JOININ_GROUP, "20", "30"};
    public static final int[] nMr = {5, 1, 4};
    private boolean YC;
    private int borderColor;
    private Context mContext;
    private String mUserID;
    private boolean nMl;
    private float nMn;
    private DanmakuContext nMo;
    private int nMs;
    private tv.chushou.zues.toolkit.richtext.a nMt;
    private a nMu;
    private b.a nMv;
    private int strokeWidth;

    /* loaded from: classes5.dex */
    public interface a {
        void bt(Object obj);
    }

    public CSDanmuLayout(Context context, tv.chushou.apollo.a aVar, String str) {
        super(context);
        this.mContext = null;
        this.nMn = 1.0f;
        this.nMv = new b.a() { // from class: tv.chushou.apollo.CSDanmuLayout.1
            @Override // master.flame.danmaku.danmaku.model.android.b.a
            public void e(d dVar, boolean z) {
            }

            @Override // master.flame.danmaku.danmaku.model.android.b.a
            public void t(d dVar) {
                if (dVar != null) {
                    dVar.text = null;
                    dVar.tag = null;
                    dVar.nxx = null;
                    dVar.obj = null;
                }
            }
        };
        this.mContext = context.getApplicationContext();
        this.nMo = DanmakuContext.dNV();
        this.mUserID = str;
        this.YC = aVar.isFullScreen;
        this.nMs = aVar.nMm;
        this.nMl = aVar.nMl;
        this.strokeWidth = aVar.strokeWidth;
        this.borderColor = aVar.borderColor;
        if (!this.YC) {
            this.nMn = 0.8f;
        } else {
            this.nMn = 1.0f;
        }
        init();
    }

    public void Sa(String str) {
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
            a(aVar, getCurrentTime() + this.nMs, true);
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
        this.nMt = new tv.chushou.apollo.a.b(tv.chushou.zues.utils.a.dip2px(this.mContext, 14.0f), this.mContext);
        HashMap hashMap = new HashMap();
        hashMap.put(1, true);
        this.nMo.c(this.nMl ? 1 : 0, this.strokeWidth).a(new i(), this.nMv).xb(false).D(hashMap);
        setCallback(new c.a() { // from class: tv.chushou.apollo.CSDanmuLayout.2
            @Override // master.flame.danmaku.a.c.a
            public void dMZ() {
                CSDanmuLayout.this.start();
            }

            @Override // master.flame.danmaku.a.c.a
            public void b(f fVar) {
            }

            @Override // master.flame.danmaku.a.c.a
            public void j(d dVar) {
            }

            @Override // master.flame.danmaku.a.c.a
            public void dNa() {
            }
        });
        setOnDanmakuClickListener(new f.a() { // from class: tv.chushou.apollo.CSDanmuLayout.3
            @Override // master.flame.danmaku.a.f.a
            public boolean a(l lVar) {
                d dNH = lVar.dNH();
                if (dNH == null || dNH.tag == null || CSDanmuLayout.this.nMu == null) {
                    return false;
                }
                CSDanmuLayout.this.nMu.bt(dNH.tag);
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
                /* renamed from: dRl */
                public master.flame.danmaku.danmaku.model.android.d dOr() {
                    return new master.flame.danmaku.danmaku.model.android.d();
                }
            }, this.nMo);
        }
        xf(true);
    }

    public void dRk() {
        wT(true);
    }

    private void a(tv.chushou.apollo.a.a aVar, long j, boolean z) {
        int Sc;
        int i;
        if (aVar != null && !h.isEmpty(aVar.mContent) && this.mContext != null) {
            float Sb = Sb(nMq[1]);
            int Sc2 = Sc(nMp[0]);
            int parseColor = Color.parseColor("#E5000000");
            int i2 = nMr[1];
            if (Sb <= 0.0f) {
                Sb = Sb(nMq[1]);
            }
            float f = Sb * this.nMn;
            String str = aVar.mContent;
            tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
            if (aVar.mType != null) {
                if (aVar.mType.equals("3")) {
                    cVar.a(aVar.mUserNickname + ":  ", new ForegroundColorSpan(this.mContext.getResources().getColor(b.a.apollo_gift_color)));
                    if (a(this.mContext, cVar, aVar.mContentRichText)) {
                        Sc2 = Sc("0xff5959");
                        cVar.append(aVar.mContent);
                    } else {
                        a(this.mContext, cVar, aVar.mContentRichText, ContextCompat.getColor(this.mContext, b.a.apollo_gift_color), -1, null, (int) f, null);
                    }
                } else if (aVar.mType.equals("2")) {
                    if (a(this.mContext, cVar, aVar.mContentRichText)) {
                        Sc2 = Sc("0xff0084");
                        cVar.append(aVar.mContent);
                    } else {
                        if (a(this.mContext, cVar, aVar.mContentRichText, ContextCompat.getColor(this.mContext, b.a.apollo_alarm_color), -1, null, (int) f, null)) {
                            i = 0;
                            Sc = Sc2;
                        } else {
                            Sc = Sc("0xff0084");
                            i = parseColor;
                        }
                        parseColor = i;
                        Sc2 = Sc;
                    }
                } else if (a(this.mContext, cVar, aVar.mContentRichText)) {
                    cVar.append(this.nMt.QB(aVar.mContent));
                } else if (a(this.mContext, cVar, aVar.mContentRichText, ContextCompat.getColor(this.mContext, b.a.apollo_white), -1, null, (int) f, this.nMt)) {
                    parseColor = 0;
                }
            } else if (a(this.mContext, cVar, aVar.mContentRichText)) {
                cVar.append(this.nMt.QB(aVar.mContent));
            } else if (a(this.mContext, cVar, aVar.mContentRichText, ContextCompat.getColor(this.mContext, b.a.apollo_white), -1, null, (int) f, this.nMt)) {
                parseColor = 0;
            }
            int i3 = i2 <= 0 ? 1 : i2;
            d JZ = this.nMo.nzu.JZ(1);
            if (JZ != null) {
                JZ.nxy = true;
                if (this.nMl) {
                    JZ.nxn = parseColor;
                }
                if (i3 == 5 && i3 == 4) {
                    JZ.padding = 20;
                }
                if (z) {
                    JZ.nxp = (byte) 100;
                    JZ.borderColor = this.borderColor;
                } else {
                    JZ.nxp = (byte) 0;
                }
                if ("3".equals(aVar.mType)) {
                    cVar.append("g");
                    String str2 = "danmu" + aVar.nMx.icon;
                    Drawable Sw = h.Sw(str2);
                    if (Sw == null) {
                        Sw = h.Sy(aVar.nMx.icon);
                        if (Sw == null) {
                            Sw = null;
                        } else {
                            h.Q(str2, Sw);
                        }
                    }
                    if (Sw == null) {
                        Sw = this.mContext.getResources().getDrawable(b.C0911b.apollo_default_gift_color);
                    }
                    if (Sw != null) {
                        int intrinsicWidth = Sw.getIntrinsicWidth();
                        int intrinsicHeight = Sw.getIntrinsicHeight();
                        int a2 = ((int) f) + ((int) tv.chushou.zues.utils.a.a(1, 3.0f, this.mContext));
                        Sw.setBounds(0, 0, (intrinsicWidth * a2) / intrinsicHeight, a2);
                        cVar.setSpan(new ImageSpan(Sw), cVar.length() - 1, cVar.length(), 33);
                    }
                    JZ.text = cVar;
                    JZ.nxn = 0;
                } else {
                    JZ.text = cVar;
                }
                JZ.setTime(j);
                JZ.bir = f;
                JZ.textColor = Sc2;
                if (aVar.tag != null) {
                    JZ.setTag(aVar.tag);
                }
                a(JZ);
            }
        }
    }

    private int getDelayTime() {
        return new Random(System.currentTimeMillis()).nextInt(this.nMs);
    }

    private float Sb(String str) {
        return tv.chushou.zues.utils.a.a(2, Math.min(Math.max(h.parseInt(str), h.parseInt(nMq[0])), h.parseInt(nMq[2])), this.mContext);
    }

    private int Sc(String str) {
        if (str == null || !str.startsWith("0x")) {
            return Color.parseColor("#ffffffff");
        }
        return Color.parseColor(str.replace("0x", "#"));
    }

    public void unInit() {
        release();
        this.mContext = null;
        this.nMo = null;
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
                Drawable Sw = h.Sw(richText.mImage);
                Drawable Sy = Sw == null ? h.Sy(richText.mImage) : Sw;
                if (Sy != null) {
                    e.d("DanmakuSurfaceView", ": null != drawable");
                    Drawable newDrawable = Sy.getConstantState().newDrawable();
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
                        r0 = aVar.QB(r0);
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
                    r02 = aVar.QB(r02);
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
        this.nMu = aVar;
    }
}
