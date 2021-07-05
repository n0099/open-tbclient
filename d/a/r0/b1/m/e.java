package d.a.r0.b1.m;

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
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.ItemStarData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.elementsMaven.span.EMRichTextAnyIconSpan;
import com.baidu.tbadk.core.util.ItemClickJumpUtil;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.r0.a0.a;
import d.a.r0.r.q.b2;
import d.a.r0.t.m;
import java.util.List;
import tbclient.HeadItem;
import tbclient.PbContent;
/* loaded from: classes9.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static String f55040a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static class a extends f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i2, String str, String str2) {
            super(i2, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = str2;
        }

        @Override // d.a.r0.b1.m.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                e.w(this.l, null);
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class b extends f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b2 l;
        public final /* synthetic */ String m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i2, String str, b2 b2Var, String str2) {
            super(i2, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), str, b2Var, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = b2Var;
            this.m = str2;
        }

        @Override // d.a.r0.b1.m.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                e.t(this.l, this.m);
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class c extends f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String l;
        public final /* synthetic */ b2 m;
        public final /* synthetic */ String n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(int i2, String str, String str2, b2 b2Var, String str3) {
            super(i2, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), str, str2, b2Var, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = str2;
            this.m = b2Var;
            this.n = str3;
        }

        @Override // d.a.r0.b1.m.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                e.u(this.l, this.m, this.n);
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class d extends f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(int i2, String str, String str2) {
            super(i2, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = str2;
        }

        @Override // d.a.r0.b1.m.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                e.v(this.l);
            }
        }
    }

    /* renamed from: d.a.r0.b1.m.e$e  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C1231e extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1231e() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
                if (currentActivity instanceof TbPageContextSupport) {
                    UrlManager.getInstance().dealOneLink((TbPageContext<?>) ((TbPageContextSupport) currentActivity).getPageContext(), new String[]{TbConfig.URL_WORKS_INFO}, true);
                }
            }
        }
    }

    public static SpannableStringBuilder A(List<PbContent> list, List<HeadItem> list2, boolean z) {
        InterceptResult invokeLLZ;
        int size;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65536, null, list, list2, z)) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (ListUtils.isEmpty(list)) {
                spannableStringBuilder.append((CharSequence) "");
            } else if (list != null && (size = list.size()) > 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    PbContent pbContent = list.get(i2);
                    if (pbContent != null && !TextUtils.isEmpty(pbContent.text)) {
                        SpannableStringBuilder spannableStringBuilder2 = null;
                        CharSequence o = o(null, pbContent);
                        if (i2 != 0 || list2 == null) {
                            c2 = 65535;
                        } else {
                            spannableStringBuilder2 = f(list2);
                            c2 = g(pbContent.type.intValue()) == 16 ? (char) 1 : (char) 0;
                        }
                        if (c2 == 65535) {
                            if (o != null) {
                                spannableStringBuilder.append(o);
                            }
                        } else if (c2 == 0) {
                            if (spannableStringBuilder2 != null) {
                                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                            }
                            if (o != null) {
                                spannableStringBuilder.append(o);
                            }
                        } else {
                            if (o != null) {
                                spannableStringBuilder.append(o);
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
        return (SpannableStringBuilder) invokeLLZ.objValue;
    }

    public static SpannableStringBuilder e(ItemStarData itemStarData) {
        InterceptResult invokeL;
        List<ItemStarData.SingleItemStar> list;
        int count;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, itemStarData)) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (itemStarData == null || (list = itemStarData.list) == null || (count = ListUtils.getCount(list)) == 0) {
                return spannableStringBuilder;
            }
            if (count == 1) {
                try {
                    i3 = Integer.parseInt(((ItemStarData.SingleItemStar) ListUtils.getItem(itemStarData.list, 0)).content);
                } catch (NumberFormatException unused) {
                    i3 = 0;
                }
                spannableStringBuilder.append((CharSequence) p(i3, false));
            } else {
                for (ItemStarData.SingleItemStar singleItemStar : itemStarData.list) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(singleItemStar.name);
                    sb.append(": ");
                    sb.append(singleItemStar.type == 1 ? singleItemStar.content : " ");
                    spannableStringBuilder.append((CharSequence) new SpannableString(sb.toString()));
                    if (singleItemStar.type == 2) {
                        try {
                            i2 = Integer.parseInt(singleItemStar.content);
                        } catch (NumberFormatException unused2) {
                            i2 = 0;
                        }
                        spannableStringBuilder.append((CharSequence) p(i2, false));
                    }
                    if (!spannableStringBuilder.toString().endsWith("\n")) {
                        spannableStringBuilder.append((CharSequence) "\n");
                    }
                }
            }
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeL.objValue;
    }

    public static SpannableStringBuilder f(List<HeadItem> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, list)) == null) {
            ItemStarData itemStarData = new ItemStarData();
            itemStarData.parseProto(list);
            return e(itemStarData);
        }
        return (SpannableStringBuilder) invokeL.objValue;
    }

    public static int g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i2)) == null) {
            if (i2 != 13) {
                if (i2 != 14) {
                    if (i2 != 18) {
                        if (i2 != 20) {
                            if (i2 != 27) {
                                switch (i2) {
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
                                        switch (i2) {
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
        return invokeI.intValue;
    }

    public static void h(StatisticItem statisticItem, b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, statisticItem, b2Var) == null) {
            if (b2Var.q2()) {
                statisticItem.param("obj_type", 2);
            } else if (b2Var.V1()) {
                statisticItem.param("obj_type", 4);
            } else if (b2Var.v1) {
                statisticItem.param("obj_type", 5);
            } else if (b2Var.E1()) {
                statisticItem.param("obj_type", 6);
            } else if (b2Var.F1()) {
                statisticItem.param("obj_type", 7);
            } else if (b2Var.H1()) {
                statisticItem.param("obj_type", 8);
            } else if (b2Var.G1()) {
                statisticItem.param("obj_type", 9);
            } else if (b2Var.getType() == b2.O2) {
                statisticItem.param("obj_type", 1);
            }
        }
    }

    public static SpannableString i(b2 b2Var, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65545, null, b2Var, str, str2)) == null) ? n(b2Var, 16, str, str2) : (SpannableString) invokeLLL.objValue;
    }

    public static SpannableString j(String str) {
        InterceptResult invokeL;
        int b2;
        String str2;
        a.C1218a c2;
        double d2;
        int a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            if (str == null || (b2 = TbFaceManager.e().b(str)) == 0) {
                return null;
            }
            String f2 = TbFaceManager.e().f(str);
            if (!TextUtils.isEmpty(str) && str.startsWith("shoubai_emoji_")) {
                str2 = PreferencesUtil.LEFT_MOUNT + f2 + PreferencesUtil.RIGHT_MOUNT;
                c2 = TbFaceManager.e().c("image_emoticon");
            } else {
                str2 = SmallTailInfo.EMOTION_PREFIX + f2 + SmallTailInfo.EMOTION_SUFFIX;
                c2 = TbFaceManager.e().c(str);
            }
            SpannableString spannableString = new SpannableString(str2 + " ");
            d.a.r0.b1.m.d dVar = new d.a.r0.b1.m.d(TbadkCoreApplication.getInst().getContext(), b2);
            if (c2 != null) {
                if (str != null && str.startsWith("bearchildren_")) {
                    d2 = 0.25d;
                    a2 = c2.a();
                } else {
                    d2 = 0.4d;
                    a2 = c2.a();
                }
                int i2 = (int) (a2 * d2);
                dVar.setBounds(new Rect(0, 0, i2, i2));
            } else {
                dVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new d.a.r0.b1.b(dVar, 2), 0, str2.length(), 33);
            return spannableString;
        }
        return (SpannableString) invokeL.objValue;
    }

    public static SpannableString k(b2 b2Var, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65547, null, b2Var, str, str2)) == null) {
            SpannableString n = n(b2Var, 18, str, str2);
            SpecHotTopicHelper.addSpecTopic(b2Var, n, n.toString(), 0);
            return n;
        }
        return (SpannableString) invokeLLL.objValue;
    }

    public static SpannableString l(b2 b2Var, int i2, String str, String str2, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{b2Var, Integer.valueOf(i2), str, str2, str3})) == null) ? q(b2Var, i2, str, str2, 0, str3) : (SpannableString) invokeCommon.objValue;
    }

    public static SpannableString m(b2 b2Var, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65549, null, b2Var, str, str2, str3)) == null) ? l(b2Var, 39, str, str2, str3) : (SpannableString) invokeLLLL.objValue;
    }

    public static SpannableString n(b2 b2Var, int i2, String str, String str2) {
        InterceptResult invokeLILL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLILL = interceptable.invokeLILL(65550, null, b2Var, i2, str, str2)) == null) ? q(b2Var, i2, str, str2, 0, null) : (SpannableString) invokeLILL.objValue;
    }

    public static CharSequence o(b2 b2Var, PbContent pbContent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, b2Var, pbContent)) == null) {
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
                            return m(b2Var, str2, pbContent.item_id + "", pbContent.item_forum_name);
                        }
                        return k(b2Var, pbContent.text, pbContent.link);
                    }
                    return i(b2Var, pbContent.text, String.valueOf(pbContent.uid));
                }
                return j(pbContent.text);
            }
            return n(b2Var, 2, pbContent.text, pbContent.link);
        }
        return (CharSequence) invokeLL.objValue;
    }

    public static SpannableString p(int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65552, null, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (i2 < 0) {
                return null;
            }
            int i3 = i2 > 5 ? 5 : i2;
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds10);
            int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds36);
            int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.tbds13);
            SpannableString spannableString = new SpannableString(TbadkCoreApplication.getInst().getString(R.string.item_stars));
            spannableString.setSpan(new d.a.r0.r.f0.q.c(i3, dimenPixelSize, dimenPixelSize2, dimenPixelSize3, 0, z), 0, spannableString.length(), 33);
            return spannableString;
        }
        return (SpannableString) invokeCommon.objValue;
    }

    public static SpannableString q(b2 b2Var, int i2, String str, String str2, int i3, String str3) {
        InterceptResult invokeCommon;
        SpannableString spannableString;
        f dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65553, null, new Object[]{b2Var, Integer.valueOf(i2), str, str2, Integer.valueOf(i3), str3})) == null) {
            String str4 = str;
            if (str4 != null) {
                boolean z = i2 == 2 && s(str, str2);
                boolean z2 = i2 == 39;
                if (!str4.endsWith(" ")) {
                    str4 = str4 + " ";
                }
                String str5 = str4;
                if (z) {
                    spannableString = new SpannableString("m" + str5);
                } else if (z2) {
                    spannableString = new SpannableString(str5 + "m");
                } else {
                    spannableString = new SpannableString(str5);
                }
                SpannableString spannableString2 = spannableString;
                if (i2 == 18) {
                    dVar = new a(i2, str2, str2);
                } else if (i2 == 16) {
                    dVar = new b(i2, str2, b2Var, str2);
                } else if (i2 == 39) {
                    dVar = new c(i2, str2, str2, b2Var, str3);
                } else {
                    dVar = new d(i2, str2, str2);
                }
                dVar.k(i3);
                if (i3 == 1) {
                    dVar.j(R.color.CAM_X0109);
                } else {
                    dVar.j(-1);
                }
                if (z) {
                    EMRichTextAnyIconSpan eMRichTextAnyIconSpan = new EMRichTextAnyIconSpan(R.drawable.icon_pure_post_link16, R.color.CAM_X0304, EMRichTextAnyIconSpan.IconType.WEBP);
                    eMRichTextAnyIconSpan.b(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
                    spannableString2.setSpan(eMRichTextAnyIconSpan, 0, 1, 33);
                    spannableString2.setSpan(dVar, 1, (str5.length() + 1) - 1, 33);
                    return spannableString2;
                } else if (z2) {
                    EMRichTextAnyIconSpan eMRichTextAnyIconSpan2 = new EMRichTextAnyIconSpan(R.drawable.icon_use_item_n, R.color.CAM_X0304, EMRichTextAnyIconSpan.IconType.WEBP);
                    eMRichTextAnyIconSpan2.d(UtilHelper.getDimenPixelSize(R.dimen.M_W_X006));
                    spannableString2.setSpan(eMRichTextAnyIconSpan2, str5.length() - 1, str5.length() + 1, 33);
                    spannableString2.setSpan(dVar, 0, str5.length() - 1, 33);
                    if (f55040a != b2Var.n1()) {
                        f55040a = b2Var.n1();
                        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_ITEM_THROUGH_EXPOSURE);
                        statisticItem.param("tid", f55040a);
                        statisticItem.param("obj_locate", b2Var.W1 ? 1 : 2);
                        TiebaStatic.log(statisticItem);
                        return spannableString2;
                    }
                    return spannableString2;
                } else {
                    spannableString2.setSpan(dVar, 0, str5.length() - 1, 33);
                    return spannableString2;
                }
            }
            return null;
        }
        return (SpannableString) invokeCommon.objValue;
    }

    public static SpannableString r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            SpannableString spannableString = new SpannableString(TbadkCoreApplication.getInst().getString(R.string.works));
            int g2 = l.g(TbadkCoreApplication.getInst(), R.dimen.L_X01);
            int g3 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10);
            int i2 = R.color.CAM_X0319;
            int i3 = R.color.CAM_X0101;
            int g4 = l.g(TbadkCoreApplication.getInst(), R.dimen.T_X10);
            int g5 = l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
            int g6 = l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
            d.a.r0.r.f0.b bVar = new d.a.r0.r.f0.b(g2, -1, i2, g4, i3, g5, l.g(TbadkCoreApplication.getInst(), R.dimen.tbds42));
            bVar.b(g3);
            bVar.i(g6);
            bVar.f(true);
            bVar.g(true);
            bVar.d(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds7));
            if (WorkIntroSwitch.isOn()) {
                spannableString.setSpan(new C1231e(), 0, spannableString.length(), 33);
            }
            spannableString.setSpan(bVar, 0, spannableString.length(), 33);
            return spannableString;
        }
        return (SpannableString) invokeV.objValue;
    }

    public static boolean s(@NonNull String str, @NonNull String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65555, null, str, str2)) == null) {
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
        return invokeLL.booleanValue;
    }

    public static void t(b2 b2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65556, null, b2Var, str) == null) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (TextUtils.isEmpty(str) || currentActivity == null) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(currentActivity, str, null)));
            if (b2Var != null) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_DYNAMIC_CARD_CLICK);
                if (b2Var.O1()) {
                    statisticItem = new StatisticItem(TbadkCoreStatisticKey.CONCERN_TAB_THREAD_CLICK);
                    statisticItem.param("obj_source", 1);
                    h(statisticItem, b2Var);
                } else if (b2Var.W1) {
                    statisticItem.param("obj_source", 2);
                    if (b2Var.J() != null) {
                        statisticItem.param("obj_type", b2Var.J().oriUgcType);
                    }
                } else {
                    statisticItem.param("obj_source", 3);
                    if (b2Var.J() != null) {
                        statisticItem.param("obj_type", b2Var.J().oriUgcType);
                    }
                }
                statisticItem.param("obj_locate", 5);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public static void u(String str, b2 b2Var, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65557, null, str, b2Var, str2) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_ITEM_THROUGH_CLICK);
            statisticItem.param("tid", b2Var.n1());
            statisticItem.param("obj_locate", b2Var.W1 ? 1 : 2);
            statisticItem.param("obj_type", str);
            TiebaStatic.log(statisticItem);
            ItemClickJumpUtil.itemClickJump(str2, str, 8, 8);
        }
    }

    public static void v(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65558, null, str) == null) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (TextUtils.isEmpty(str) || !(currentActivity instanceof TbPageContextSupport)) {
                return;
            }
            UrlManager.getInstance().dealOneLink(((TbPageContextSupport) currentActivity).getPageContext(), new String[]{str});
        }
    }

    public static void w(String str, b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65559, null, str, b2Var) == null) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (TextUtils.isEmpty(str) || !(currentActivity instanceof TbPageContextSupport)) {
                return;
            }
            TbPageContextSupport tbPageContextSupport = (TbPageContextSupport) currentActivity;
            m mVar = new m();
            mVar.f56722a = str;
            if (b2Var != null) {
                mVar.f56723b = b2Var.Q0();
                mVar.f56724c = b2Var.C0();
            }
            d.a.r0.p0.b.i(mVar);
            UrlManager.getInstance().dealOneLink(tbPageContextSupport.getPageContext(), new String[]{mVar.f56722a, mVar.f56724c});
        }
    }

    public static SpannableStringBuilder x(b2 b2Var, List<PbContent> list, String str) {
        InterceptResult invokeLLL;
        int size;
        CharSequence o;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65560, null, b2Var, list, str)) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (ListUtils.isEmpty(list)) {
                if (str == null) {
                    str = "";
                }
                spannableStringBuilder.append((CharSequence) str);
            } else if (list != null && (size = list.size()) > 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    PbContent pbContent = list.get(i2);
                    if (pbContent != null && !TextUtils.isEmpty(pbContent.text) && (o = o(b2Var, pbContent)) != null) {
                        spannableStringBuilder.append(o);
                    }
                }
            }
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeLLL.objValue;
    }

    public static SpannableStringBuilder y(List<PbContent> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65561, null, list)) == null) ? z(list, "") : (SpannableStringBuilder) invokeL.objValue;
    }

    public static SpannableStringBuilder z(List<PbContent> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65562, null, list, str)) == null) ? x(null, list, str) : (SpannableStringBuilder) invokeLL.objValue;
    }
}
