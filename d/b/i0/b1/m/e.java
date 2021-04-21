package d.b.i0.b1.m;

import android.app.Activity;
import android.graphics.Rect;
import android.net.Uri;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.ItemStarData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.elementsMaven.span.EMRichTextAnyIconSpan;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SpecHotTopicHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.switchs.WorkIntroSwitch;
import com.baidu.tieba.R;
import d.b.c.e.p.k;
import d.b.c.e.p.l;
import d.b.i0.a0.a;
import d.b.i0.r.q.a2;
import d.b.j0.d3.h0.m;
import java.util.HashMap;
import java.util.List;
import tbclient.HeadItem;
import tbclient.PbContent;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static String f50703a;

    /* loaded from: classes3.dex */
    public static class a extends f {
        public final /* synthetic */ String l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i, String str, String str2) {
            super(i, str);
            this.l = str2;
        }

        @Override // d.b.i0.b1.m.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            e.v(this.l, null);
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends f {
        public final /* synthetic */ a2 l;
        public final /* synthetic */ String m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i, String str, a2 a2Var, String str2) {
            super(i, str);
            this.l = a2Var;
            this.m = str2;
        }

        @Override // d.b.i0.b1.m.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            e.s(this.l, this.m);
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends f {
        public final /* synthetic */ String l;
        public final /* synthetic */ a2 m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(int i, String str, String str2, a2 a2Var) {
            super(i, str);
            this.l = str2;
            this.m = a2Var;
        }

        @Override // d.b.i0.b1.m.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            e.t(this.l, this.m);
        }
    }

    /* loaded from: classes3.dex */
    public static class d extends f {
        public final /* synthetic */ String l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(int i, String str, String str2) {
            super(i, str);
            this.l = str2;
        }

        @Override // d.b.i0.b1.m.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            e.u(this.l);
        }
    }

    /* renamed from: d.b.i0.b1.m.e$e  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1090e extends ClickableSpan {
        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity instanceof TbPageContextSupport) {
                UrlManager.getInstance().dealOneLink((TbPageContext<?>) ((TbPageContextSupport) currentActivity).getPageContext(), new String[]{TbConfig.URL_WORKS_INFO}, true);
            }
        }
    }

    public static SpannableStringBuilder e(ItemStarData itemStarData) {
        List<ItemStarData.SingleItemStar> list;
        int count;
        int i;
        int i2;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (itemStarData == null || (list = itemStarData.list) == null || (count = ListUtils.getCount(list)) == 0) {
            return spannableStringBuilder;
        }
        if (count == 1) {
            try {
                i2 = Integer.parseInt(((ItemStarData.SingleItemStar) ListUtils.getItem(itemStarData.list, 0)).content);
            } catch (NumberFormatException unused) {
                i2 = 0;
            }
            spannableStringBuilder.append((CharSequence) o(i2, false));
        } else {
            for (ItemStarData.SingleItemStar singleItemStar : itemStarData.list) {
                StringBuilder sb = new StringBuilder();
                sb.append(singleItemStar.name);
                sb.append(": ");
                sb.append(singleItemStar.type == 1 ? singleItemStar.content : " ");
                spannableStringBuilder.append((CharSequence) new SpannableString(sb.toString()));
                if (singleItemStar.type == 2) {
                    try {
                        i = Integer.parseInt(singleItemStar.content);
                    } catch (NumberFormatException unused2) {
                        i = 0;
                    }
                    spannableStringBuilder.append((CharSequence) o(i, false));
                }
                if (!spannableStringBuilder.toString().endsWith("\n")) {
                    spannableStringBuilder.append((CharSequence) "\n");
                }
            }
        }
        return spannableStringBuilder;
    }

    public static SpannableStringBuilder f(List<HeadItem> list) {
        ItemStarData itemStarData = new ItemStarData();
        itemStarData.parseProto(list);
        return e(itemStarData);
    }

    public static int g(int i) {
        if (i != 13) {
            if (i != 14) {
                if (i != 18) {
                    if (i != 20) {
                        if (i != 27) {
                            switch (i) {
                                case 0:
                                    return 1;
                                case 1:
                                    return 2;
                                case 2:
                                    return 4;
                                case 3:
                                    return 8;
                                case 4:
                                    return 16;
                                case 5:
                                    return 32;
                                case 6:
                                    return 64;
                                default:
                                    switch (i) {
                                        case 8:
                                            return 128;
                                        case 9:
                                            return 256;
                                        case 10:
                                            return 512;
                                        case 11:
                                            return 17;
                                        default:
                                            return 0;
                                    }
                            }
                        }
                        return 39;
                    }
                    return 20;
                }
                return 18;
            }
            return 1280;
        }
        return 1024;
    }

    public static void h(StatisticItem statisticItem, a2 a2Var) {
        if (a2Var.z2()) {
            statisticItem.param("obj_type", 2);
        } else if (a2Var.f2()) {
            statisticItem.param("obj_type", 4);
        } else if (a2Var.s1) {
            statisticItem.param("obj_type", 5);
        } else if (a2Var.O1()) {
            statisticItem.param("obj_type", 6);
        } else if (a2Var.P1()) {
            statisticItem.param("obj_type", 7);
        } else if (a2Var.R1()) {
            statisticItem.param("obj_type", 8);
        } else if (a2Var.Q1()) {
            statisticItem.param("obj_type", 9);
        } else if (a2Var.getType() == a2.H2) {
            statisticItem.param("obj_type", 1);
        }
    }

    public static SpannableString i(a2 a2Var, String str, String str2) {
        return m(a2Var, 16, str, str2);
    }

    public static SpannableString j(String str) {
        int b2;
        String str2;
        a.C1077a c2;
        double d2;
        int a2;
        if (str == null || (b2 = TbFaceManager.e().b(str)) == 0) {
            return null;
        }
        String f2 = TbFaceManager.e().f(str);
        if (!TextUtils.isEmpty(str) && str.startsWith("shoubai_emoji_")) {
            str2 = "[" + f2 + "]";
            c2 = TbFaceManager.e().c("image_emoticon");
        } else {
            str2 = SmallTailInfo.EMOTION_PREFIX + f2 + SmallTailInfo.EMOTION_SUFFIX;
            c2 = TbFaceManager.e().c(str);
        }
        SpannableString spannableString = new SpannableString(str2 + " ");
        d.b.i0.b1.m.d dVar = new d.b.i0.b1.m.d(TbadkCoreApplication.getInst().getContext(), b2);
        if (c2 != null) {
            if (str != null && str.startsWith("bearchildren_")) {
                d2 = 0.25d;
                a2 = c2.a();
            } else {
                d2 = 0.4d;
                a2 = c2.a();
            }
            int i = (int) (a2 * d2);
            dVar.setBounds(new Rect(0, 0, i, i));
        } else {
            dVar.setBounds(new Rect(0, 0, 0, 0));
        }
        spannableString.setSpan(new d.b.i0.b1.b(dVar, 2), 0, str2.length(), 33);
        return spannableString;
    }

    public static SpannableString k(a2 a2Var, String str, String str2) {
        SpannableString m = m(a2Var, 18, str, str2);
        SpecHotTopicHelper.addSpecTopic(a2Var, m, m.toString(), 0);
        return m;
    }

    public static SpannableString l(a2 a2Var, String str, String str2) {
        return m(a2Var, 39, str, str2);
    }

    public static SpannableString m(a2 a2Var, int i, String str, String str2) {
        return p(a2Var, i, str, str2, 0);
    }

    public static CharSequence n(a2 a2Var, PbContent pbContent) {
        int g2 = g(pbContent.type.intValue());
        if (g2 != 2) {
            if (g2 != 4) {
                if (g2 != 16) {
                    if (g2 != 18) {
                        if (g2 != 39) {
                            String str = pbContent.text;
                            return new SpannableString(str != null ? str : "");
                        }
                        String str2 = pbContent.text;
                        return l(a2Var, str2, pbContent.item_id + "");
                    }
                    return k(a2Var, pbContent.text, pbContent.link);
                }
                return i(a2Var, pbContent.text, String.valueOf(pbContent.uid));
            }
            return j(pbContent.text);
        }
        return m(a2Var, 2, pbContent.text, pbContent.link);
    }

    public static SpannableString o(int i, boolean z) {
        if (i < 0) {
            return null;
        }
        int i2 = i > 5 ? 5 : i;
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds10);
        int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds36);
        int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.tbds13);
        SpannableString spannableString = new SpannableString(TbadkCoreApplication.getInst().getString(R.string.item_stars));
        spannableString.setSpan(new d.b.i0.r.f0.o.c(i2, dimenPixelSize, dimenPixelSize2, dimenPixelSize3, 0, z), 0, spannableString.length(), 33);
        return spannableString;
    }

    public static SpannableString p(a2 a2Var, int i, String str, String str2, int i2) {
        SpannableString spannableString;
        f dVar;
        if (str != null) {
            boolean z = i == 2 && r(str, str2);
            boolean z2 = i == 39;
            if (!str.endsWith(" ")) {
                str = str + " ";
            }
            if (z) {
                spannableString = new SpannableString("m" + str);
            } else if (z2) {
                spannableString = new SpannableString(str + "m");
            } else {
                spannableString = new SpannableString(str);
            }
            if (i == 18) {
                dVar = new a(i, str2, str2);
            } else if (i == 16) {
                dVar = new b(i, str2, a2Var, str2);
            } else if (i == 39) {
                dVar = new c(i, str2, str2, a2Var);
            } else {
                dVar = new d(i, str2, str2);
            }
            dVar.k(i2);
            if (i2 == 1) {
                dVar.j(R.color.CAM_X0109);
            } else {
                dVar.j(-1);
            }
            if (z) {
                EMRichTextAnyIconSpan eMRichTextAnyIconSpan = new EMRichTextAnyIconSpan(R.drawable.icon_pure_post_link16, R.color.CAM_X0304, EMRichTextAnyIconSpan.IconType.WEBP);
                eMRichTextAnyIconSpan.b(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
                spannableString.setSpan(eMRichTextAnyIconSpan, 0, 1, 33);
                spannableString.setSpan(dVar, 1, (str.length() + 1) - 1, 33);
                return spannableString;
            } else if (z2) {
                EMRichTextAnyIconSpan eMRichTextAnyIconSpan2 = new EMRichTextAnyIconSpan(R.drawable.icon_use_item_n, R.color.CAM_X0304, EMRichTextAnyIconSpan.IconType.WEBP);
                eMRichTextAnyIconSpan2.d(UtilHelper.getDimenPixelSize(R.dimen.M_W_X006));
                spannableString.setSpan(eMRichTextAnyIconSpan2, str.length() - 1, str.length() + 1, 33);
                spannableString.setSpan(dVar, 0, str.length() - 1, 33);
                if (f50703a != a2Var.w1()) {
                    f50703a = a2Var.w1();
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_ITEM_THROUGH_EXPOSURE);
                    statisticItem.param("tid", f50703a);
                    statisticItem.param("obj_locate", a2Var.T1 ? 1 : 2);
                    TiebaStatic.log(statisticItem);
                    return spannableString;
                }
                return spannableString;
            } else {
                spannableString.setSpan(dVar, 0, str.length() - 1, 33);
                return spannableString;
            }
        }
        return null;
    }

    public static SpannableString q() {
        SpannableString spannableString = new SpannableString(TbadkCoreApplication.getInst().getString(R.string.works));
        int g2 = l.g(TbadkCoreApplication.getInst(), R.dimen.L_X01);
        int g3 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10);
        int i = R.color.CAM_X0301;
        int i2 = R.color.CAM_X0101;
        int g4 = l.g(TbadkCoreApplication.getInst(), R.dimen.T_X10);
        int g5 = l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
        int g6 = l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
        d.b.i0.r.f0.b bVar = new d.b.i0.r.f0.b(g2, -1, i, g4, i2, g5, l.g(TbadkCoreApplication.getInst(), R.dimen.tbds42));
        bVar.b(g3);
        bVar.i(g6);
        bVar.f(true);
        bVar.g(true);
        bVar.d(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds7));
        if (WorkIntroSwitch.isOn()) {
            spannableString.setSpan(new C1090e(), 0, spannableString.length(), 33);
        }
        spannableString.setSpan(bVar, 0, spannableString.length(), 33);
        return spannableString;
    }

    public static boolean r(@NonNull String str, @NonNull String str2) {
        if (k.isEmpty(str) || k.isEmpty(str2)) {
            return false;
        }
        if (UrlManager.getInstance().isUrlValid(str2) && UrlManager.getInstance().isUrlValid(str)) {
            if (str.equals(str2)) {
                return false;
            }
            List<String> queryParameters = Uri.parse(str2).getQueryParameters("url");
            if (ListUtils.isEmpty(queryParameters)) {
                return true;
            }
            String str3 = queryParameters.get(0);
            if (!str.equals(str3)) {
                if (!("http://" + str).equals(str3)) {
                    if (("https://" + str).equals(str3)) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    public static void s(a2 a2Var, String str) {
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (TextUtils.isEmpty(str) || currentActivity == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(currentActivity, str, null)));
        if (a2Var != null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_DYNAMIC_CARD_CLICK);
            if (a2Var.Y1()) {
                statisticItem = new StatisticItem(TbadkCoreStatisticKey.CONCERN_TAB_THREAD_CLICK);
                statisticItem.param("obj_source", 1);
                h(statisticItem, a2Var);
            } else if (a2Var.T1) {
                statisticItem.param("obj_source", 2);
                if (a2Var.V() != null) {
                    statisticItem.param("obj_type", a2Var.V().oriUgcType);
                }
            } else {
                statisticItem.param("obj_source", 3);
                if (a2Var.V() != null) {
                    statisticItem.param("obj_type", a2Var.V().oriUgcType);
                }
            }
            statisticItem.param("obj_locate", 5);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void t(String str, a2 a2Var) {
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_ITEM_THROUGH_CLICK);
        statisticItem.param("tid", a2Var.w1());
        statisticItem.param("obj_locate", a2Var.T1 ? 1 : 2);
        statisticItem.param("obj_type", str);
        TiebaStatic.log(statisticItem);
        HashMap hashMap = new HashMap(1);
        hashMap.put("itemID", str);
        hashMap.put("source", 8);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(TbadkApplication.getInst().getApplicationContext(), "GameItemDetailsPage", hashMap)));
    }

    public static void u(String str) {
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (TextUtils.isEmpty(str) || !(currentActivity instanceof TbPageContextSupport)) {
            return;
        }
        UrlManager.getInstance().dealOneLink(((TbPageContextSupport) currentActivity).getPageContext(), new String[]{str});
    }

    public static void v(String str, a2 a2Var) {
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (TextUtils.isEmpty(str) || !(currentActivity instanceof TbPageContextSupport)) {
            return;
        }
        TbPageContextSupport tbPageContextSupport = (TbPageContextSupport) currentActivity;
        d.b.i0.t.m mVar = new d.b.i0.t.m();
        mVar.f52236a = str;
        if (a2Var != null) {
            mVar.f52237b = a2Var.a1();
            mVar.f52238c = a2Var.N0();
        }
        d.b.i0.p0.b.i(mVar);
        UrlManager.getInstance().dealOneLink(tbPageContextSupport.getPageContext(), new String[]{mVar.f52236a, mVar.f52238c});
    }

    public static SpannableStringBuilder w(a2 a2Var, List<PbContent> list, String str) {
        int size;
        CharSequence n;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (ListUtils.isEmpty(list)) {
            if (str == null) {
                str = "";
            }
            spannableStringBuilder.append((CharSequence) str);
        } else if (list != null && (size = list.size()) > 0) {
            for (int i = 0; i < size; i++) {
                PbContent pbContent = list.get(i);
                if (pbContent != null && !TextUtils.isEmpty(pbContent.text) && (n = n(a2Var, pbContent)) != null) {
                    spannableStringBuilder.append(n);
                }
            }
        }
        return spannableStringBuilder;
    }

    public static SpannableStringBuilder x(List<PbContent> list) {
        return y(list, "");
    }

    public static SpannableStringBuilder y(List<PbContent> list, String str) {
        return w(null, list, str);
    }

    public static SpannableStringBuilder z(List<PbContent> list, List<HeadItem> list2, boolean z) {
        int size;
        char c2;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (ListUtils.isEmpty(list)) {
            spannableStringBuilder.append((CharSequence) "");
        } else if (list != null && (size = list.size()) > 0) {
            for (int i = 0; i < size; i++) {
                PbContent pbContent = list.get(i);
                if (pbContent != null && !TextUtils.isEmpty(pbContent.text)) {
                    SpannableStringBuilder spannableStringBuilder2 = null;
                    CharSequence n = n(null, pbContent);
                    if (i != 0 || list2 == null) {
                        c2 = 65535;
                    } else {
                        spannableStringBuilder2 = f(list2);
                        c2 = g(pbContent.type.intValue()) == 16 ? (char) 1 : (char) 0;
                    }
                    if (c2 == 65535) {
                        if (n != null) {
                            spannableStringBuilder.append(n);
                        }
                    } else if (c2 == 0) {
                        if (spannableStringBuilder2 != null) {
                            spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                        }
                        if (n != null) {
                            spannableStringBuilder.append(n);
                        }
                    } else {
                        if (n != null) {
                            spannableStringBuilder.append(n);
                        }
                        if (spannableStringBuilder2 != null) {
                            if (z) {
                                spannableStringBuilder.append((CharSequence) "\n");
                            }
                            spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                        }
                    }
                }
            }
        }
        return spannableStringBuilder;
    }
}
