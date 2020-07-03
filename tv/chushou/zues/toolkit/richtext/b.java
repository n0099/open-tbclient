package tv.chushou.zues.toolkit.richtext;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import com.facebook.drawee.span.SimpleDraweeSpanTextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tv.chushou.zues.utils.h;
import tv.chushou.zues.widget.a.c;
import tv.chushou.zues.widget.a.e;
/* loaded from: classes5.dex */
public class b {
    public static ArrayList<RichText> Te(String str) {
        String[] split;
        ArrayList<RichText> arrayList = new ArrayList<>();
        if (!h.isEmpty(str)) {
            for (String str2 : str.split("]]>")) {
                int indexOf = str2.indexOf("<![JSON[");
                if (indexOf == -1) {
                    RichText richText = new RichText();
                    richText.mType = -1;
                    richText.mContent = str2;
                    arrayList.add(richText);
                } else {
                    if (indexOf > 0) {
                        String substring = str2.substring(0, indexOf);
                        RichText richText2 = new RichText();
                        richText2.mType = -1;
                        richText2.mContent = substring;
                        arrayList.add(richText2);
                    }
                    RichText Tf = Tf(str2.substring(indexOf + "<![JSON[".length()));
                    if (Tf != null) {
                        arrayList.add(Tf);
                    }
                }
            }
        }
        return arrayList;
    }

    public static boolean a(Context context, c cVar, ArrayList<RichText> arrayList, int i, @ColorInt int i2, View view) {
        return a(context, cVar, arrayList, i, i2, view, null, null);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:41:0x011d */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:72:0x0200 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [tv.chushou.zues.widget.a.c] */
    /* JADX WARN: Type inference failed for: r17v0, types: [tv.chushou.zues.toolkit.richtext.a] */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r1v22, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v23, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r1v24, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r1v38 */
    /* JADX WARN: Type inference failed for: r1v39 */
    /* JADX WARN: Type inference failed for: r1v40 */
    /* JADX WARN: Type inference failed for: r1v41 */
    /* JADX WARN: Type inference failed for: r1v42 */
    /* JADX WARN: Type inference failed for: r1v43 */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.lang.String] */
    public static boolean a(Context context, c cVar, ArrayList<RichText> arrayList, int i, @ColorInt int i2, View view, String str, a aVar) {
        Drawable drawable;
        if (context == null || cVar == 0 || h.isEmpty(arrayList)) {
            return false;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 < arrayList.size()) {
                RichText richText = arrayList.get(i4);
                if (richText.mType == 2) {
                    if (view != null) {
                        int a = (int) tv.chushou.zues.utils.a.a(1, i + 3, context);
                        int length = cVar.length();
                        if (view instanceof SimpleDraweeSpanTextView) {
                            com.facebook.drawee.view.b a2 = com.facebook.drawee.view.b.a(new com.facebook.drawee.generic.b(context.getResources()).dBx(), h.dWe());
                            a2.setController(com.facebook.drawee.a.a.c.dzW().wy(true).QH(richText.mImage).dAN());
                            cVar.append(" ");
                            cVar.a(a2, length, length, 20, a, true, 2);
                        }
                    }
                    Drawable Ti = h.Ti(richText.mImage);
                    Drawable Tk = Ti == null ? h.Tk(richText.mImage) : Ti;
                    if (Tk != null) {
                        Drawable newDrawable = Tk.getConstantState().newDrawable();
                        int intrinsicWidth = newDrawable.getIntrinsicWidth();
                        int intrinsicHeight = newDrawable.getIntrinsicHeight();
                        int a3 = (int) tv.chushou.zues.utils.a.a(1, i + 3, context);
                        newDrawable.setBounds(0, 0, (intrinsicWidth * a3) / intrinsicHeight, a3);
                        cVar.a("", new e(newDrawable));
                    }
                } else if (richText.mType == 1) {
                    if (!h.isEmpty(richText.mContent)) {
                        ArrayList arrayList2 = new ArrayList();
                        if (!h.isEmpty(richText.mBackgroundColor)) {
                            arrayList2.add(new BackgroundColorSpan(Color.parseColor(richText.mBackgroundColor)));
                        }
                        if (!h.isEmpty(richText.mFontColor)) {
                            arrayList2.add(new ForegroundColorSpan(Color.parseColor(richText.mFontColor)));
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
                        ?? r1 = str2;
                        if (!h.isEmpty(str)) {
                            boolean endsWith = str2.endsWith(str);
                            r1 = str2;
                            if (!endsWith) {
                                r1 = str2 + str;
                            }
                        }
                        if (aVar != 0) {
                            r1 = aVar.Rn(r1);
                        }
                        if (arrayList2.size() > 0) {
                            cVar.a(r1, arrayList2);
                        } else {
                            cVar.append(r1);
                        }
                    }
                } else if (richText.mType == 5) {
                    String str3 = "res_" + richText.mDrawableId;
                    Drawable Ti2 = h.Ti(str3);
                    if (Ti2 == null) {
                        drawable = h.dWI().getDrawable(richText.mDrawableId);
                        h.Q(str3, drawable);
                    } else {
                        drawable = Ti2;
                    }
                    if (drawable != null) {
                        Drawable newDrawable2 = drawable.getConstantState().newDrawable();
                        int intrinsicWidth2 = newDrawable2.getIntrinsicWidth();
                        int intrinsicHeight2 = newDrawable2.getIntrinsicHeight();
                        int a4 = (int) tv.chushou.zues.utils.a.a(1, i + 3, context);
                        newDrawable2.setBounds(0, 0, (intrinsicWidth2 * a4) / intrinsicHeight2, a4);
                        cVar.a("", new e(newDrawable2));
                    }
                } else if (!h.isEmpty(richText.mContent)) {
                    char[] charArray = richText.mContent.toCharArray();
                    if (charArray.length != 1 || charArray[0] != 8206) {
                        String str4 = richText.mContent;
                        ?? r12 = str4;
                        if (!h.isEmpty(str)) {
                            boolean endsWith2 = str4.endsWith(str);
                            r12 = str4;
                            if (!endsWith2) {
                                r12 = str4 + str;
                            }
                        }
                        if (aVar != 0) {
                            r12 = aVar.Rn(r12);
                        }
                        cVar.a(r12, new ForegroundColorSpan(i2));
                    }
                }
                i3 = i4 + 1;
            } else {
                return true;
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:51:0x0148 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [tv.chushou.zues.widget.a.c] */
    /* JADX WARN: Type inference failed for: r17v0, types: [tv.chushou.zues.toolkit.richtext.a] */
    /* JADX WARN: Type inference failed for: r1v17, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r1v28, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v29, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r1v30, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r1v44 */
    /* JADX WARN: Type inference failed for: r1v45 */
    /* JADX WARN: Type inference failed for: r1v46 */
    public static boolean a(Context context, c cVar, ArrayList<RichText> arrayList, int i, @ColorInt int i2, View view, String str, a aVar, HashMap<String, String> hashMap) {
        Drawable drawable;
        if (context == null || cVar == 0 || h.isEmpty(arrayList)) {
            return false;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 < arrayList.size()) {
                RichText richText = arrayList.get(i4);
                if (richText.mType == 2) {
                    if (view != null) {
                        int a = (int) tv.chushou.zues.utils.a.a(1, i + 3, context);
                        int length = cVar.length();
                        if (view instanceof SimpleDraweeSpanTextView) {
                            com.facebook.drawee.view.b a2 = com.facebook.drawee.view.b.a(new com.facebook.drawee.generic.b(context.getResources()).dBx(), h.dWe());
                            a2.setController(com.facebook.drawee.a.a.c.dzW().QH(richText.mImage).dAN());
                            cVar.append(" ");
                            cVar.a(a2, length, length, 20, a, true, 2);
                        }
                    }
                    Drawable Ti = h.Ti(richText.mImage);
                    Drawable Tk = Ti == null ? h.Tk(richText.mImage) : Ti;
                    if (Tk != null) {
                        Drawable newDrawable = Tk.getConstantState().newDrawable();
                        int intrinsicWidth = newDrawable.getIntrinsicWidth();
                        int intrinsicHeight = newDrawable.getIntrinsicHeight();
                        int a3 = (int) tv.chushou.zues.utils.a.a(1, i + 3, context);
                        newDrawable.setBounds(0, 0, (intrinsicWidth * a3) / intrinsicHeight, a3);
                        cVar.a("", new e(newDrawable));
                    }
                } else if (richText.mType == 1) {
                    if (!h.isEmpty(richText.mContent)) {
                        ArrayList arrayList2 = new ArrayList();
                        if (!h.isEmpty(richText.mBackgroundColor)) {
                            String str2 = "";
                            if (hashMap != null) {
                                str2 = hashMap.get(richText.mBackgroundColor.toLowerCase());
                            }
                            if (h.isEmpty(str2)) {
                                arrayList2.add(new BackgroundColorSpan(Color.parseColor(richText.mBackgroundColor)));
                            } else {
                                arrayList2.add(new BackgroundColorSpan(Color.parseColor(str2)));
                            }
                        }
                        if (!h.isEmpty(richText.mFontColor)) {
                            String str3 = "";
                            if (hashMap != null) {
                                str3 = hashMap.get(richText.mFontColor.toLowerCase());
                            }
                            if (h.isEmpty(str3)) {
                                arrayList2.add(new ForegroundColorSpan(Color.parseColor(richText.mFontColor)));
                            } else {
                                arrayList2.add(new ForegroundColorSpan(Color.parseColor(str3)));
                            }
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
                        String str4 = richText.mContent;
                        ?? r1 = str4;
                        if (!h.isEmpty(str)) {
                            boolean endsWith = str4.endsWith(str);
                            r1 = str4;
                            if (!endsWith) {
                                r1 = str4 + str;
                            }
                        }
                        if (aVar != 0) {
                            r1 = aVar.Rn(r1);
                        }
                        if (arrayList2.size() > 0) {
                            cVar.a(r1, arrayList2);
                        } else {
                            cVar.append(r1);
                        }
                    }
                } else if (richText.mType == 5) {
                    String str5 = "res_" + richText.mDrawableId;
                    Drawable Ti2 = h.Ti(str5);
                    if (Ti2 == null) {
                        drawable = h.dWI().getDrawable(richText.mDrawableId);
                        h.Q(str5, drawable);
                    } else {
                        drawable = Ti2;
                    }
                    if (drawable != null) {
                        Drawable newDrawable2 = drawable.getConstantState().newDrawable();
                        int intrinsicWidth2 = newDrawable2.getIntrinsicWidth();
                        int intrinsicHeight2 = newDrawable2.getIntrinsicHeight();
                        int a4 = (int) tv.chushou.zues.utils.a.a(1, i + 3, context);
                        newDrawable2.setBounds(0, 0, (intrinsicWidth2 * a4) / intrinsicHeight2, a4);
                        cVar.a("", new e(newDrawable2));
                    }
                } else if (!h.isEmpty(richText.mContent)) {
                    char[] charArray = richText.mContent.toCharArray();
                    if (charArray.length != 1 || charArray[0] != 8206) {
                        String str6 = richText.mContent;
                        if (!h.isEmpty(str) && !str6.endsWith(str)) {
                            str6 = str6 + str;
                        }
                        String Rn = aVar != 0 ? aVar.Rn(str6) : str6;
                        String str7 = "";
                        if (hashMap != null) {
                            str7 = hashMap.get(tv.chushou.zues.utils.a.LG(i2));
                        }
                        if (h.isEmpty(str7)) {
                            cVar.a(Rn, new ForegroundColorSpan(i2));
                        } else {
                            cVar.a(Rn, new ForegroundColorSpan(Color.parseColor(str7)));
                        }
                    }
                }
                i3 = i4 + 1;
            } else {
                return true;
            }
        }
    }

    private static RichText Tf(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            RichText richText = new RichText();
            richText.mType = jSONObject.optInt("type");
            if (richText.mType == 2 || richText.mType == 1 || richText.mType == 3) {
                richText.mImage = jSONObject.optString("image");
                richText.mUrl = jSONObject.optString("url");
                richText.mUrlDesc = jSONObject.optString("name");
                richText.mContent = jSONObject.optString("content");
                richText.mFontColor = jSONObject.optString("fontColor");
                richText.mFontSizeLevel = jSONObject.optInt("fontSizeLevel");
                richText.mBackgroundColor = jSONObject.optString("backgroundColor");
                richText.mFontStyle = jSONObject.optInt("style");
            } else {
                richText.mType = -1;
                richText.mContent = jSONObject.optString("content");
            }
            return richText;
        } catch (JSONException e) {
            tv.chushou.zues.utils.e.e("RichTextHelper", "ParseRichJson error=" + e.toString());
            return null;
        }
    }

    private static StringBuilder b(StringBuilder sb, String str, String str2) {
        sb.append("<![JSON[{\"type\": 1, \"content\": \"").append(str).append("\", \"fontColor\":\"").append(str2).append("\"}]]>");
        return sb;
    }

    public static String a(String str, List<String> list, boolean z, int i) {
        if (list != null && list.size() != 0) {
            StringBuilder sb = new StringBuilder();
            if (z) {
                b(sb, str, list.get(i));
            } else {
                int size = list.size();
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= str.length()) {
                        break;
                    }
                    b(sb, String.valueOf(str.charAt(i3)), list.get((i + i3) % size));
                    i2 = i3 + 1;
                }
            }
            return sb.toString();
        }
        return str;
    }
}
