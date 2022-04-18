package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.net.Uri;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.common.others.url.UrlUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.ItemStarData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.elementsMaven.span.EMRichTextAnyIconSpan;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ItemClickJumpUtil;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SpecHotTopicHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.tbselector.utils.SelectorHelper;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.module.hottopic.HotTopicStat;
import com.baidu.tbadk.util.TiePlusHelper;
import com.baidu.tbadk.widget.richText.RichTextMaker;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.tiejia.TiePlusEventController;
import com.baidu.tbadk.widget.tiejia.TiePlusStat;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.f35;
import java.util.ArrayList;
import java.util.List;
import tbclient.HeadItem;
import tbclient.PbContent;
import tbclient.TiebaPlusInfo;
/* loaded from: classes5.dex */
public class ef5 {
    public static /* synthetic */ Interceptable $ic;
    public static String a;
    public static final h b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a extends RichTextMaker<z45> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            h(R.drawable.obfuscated_res_0x7f0809ec);
            i(R.dimen.tbds3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.widget.richText.RichTextMaker
        @NonNull
        /* renamed from: j */
        public SpannableString b(int i, @NonNull String str, @NonNull z45 z45Var) {
            InterceptResult invokeILL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, str, z45Var)) == null) {
                if (z45Var.n() && str.contains("[视频]")) {
                    z45Var.p(true);
                    str = str.replace("[视频]", "");
                }
                f(z45Var.m());
                g(z45Var.o() ? RichTextMaker.IconPos.START_OFFSET.setOffset(1) : RichTextMaker.IconPos.NONE);
                return super.b(i, str, z45Var);
            }
            return (SpannableString) invokeILL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.widget.richText.RichTextMaker
        /* renamed from: k */
        public void c(@NonNull View view2, int i, @NonNull z45 z45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048579, this, view2, i, z45Var) == null) {
                if (z45Var.n()) {
                    Context context = view2.getContext();
                    BdToast.i(context, context.getString(R.string.obfuscated_res_0x7f0f14d0), R.drawable.obfuscated_res_0x7f0809a9, true).q();
                    return;
                }
                if (z45Var.o()) {
                    HotTopicStat.a(UrlUtils.getParamValue(z45Var.h(), "topic_id"), UrlUtils.getParamValue(z45Var.h(), IntentConfig.TOPIC_NAME), z45Var.i(), z45Var.g(), z45Var.k());
                }
                ef5.B(z45Var.h(), z45Var.l());
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b extends RichTextMaker<nf5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(RichTextMaker.IconPos iconPos, int i, int i2, int i3) {
            super(iconPos, i, i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iconPos, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((RichTextMaker.IconPos) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.widget.richText.RichTextMaker
        /* renamed from: j */
        public void c(@NonNull View view2, int i, @NonNull nf5 nf5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, i, nf5Var) == null) {
                nf5Var.q(TiePlusStat.StatType.CLICK);
                TiePlusEventController.onEvent(nf5Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c extends ff5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(int i, String str, String str2) {
            super(i, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = str2;
        }

        @Override // com.repackage.ff5, android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ef5.B(this.h, null);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class d extends ff5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(int i, String str) {
            super(i, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // com.repackage.ff5, android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                BdToast.i(SelectorHelper.getContext(), SelectorHelper.getContext().getString(R.string.obfuscated_res_0x7f0f14d0), R.drawable.obfuscated_res_0x7f0809a9, true).q();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class e extends ff5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThreadData h;
        public final /* synthetic */ String i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(int i, String str, ThreadData threadData, String str2) {
            super(i, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), str, threadData, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = threadData;
            this.i = str2;
        }

        @Override // com.repackage.ff5, android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ef5.y(this.h, this.i);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class f extends ff5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String h;
        public final /* synthetic */ ThreadData i;
        public final /* synthetic */ String j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(int i, String str, String str2, ThreadData threadData, String str3) {
            super(i, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), str, str2, threadData, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = str2;
            this.i = threadData;
            this.j = str3;
        }

        @Override // com.repackage.ff5, android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ef5.z(this.h, this.i, this.j);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class g extends ff5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(int i, String str, String str2) {
            super(i, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = str2;
        }

        @Override // com.repackage.ff5, android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ef5.A(this.h);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public SparseArray<RichTextMaker<?>> a;

        public h() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new SparseArray<>();
        }

        public <T> RichTextMaker<T> a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? (RichTextMaker<T>) this.a.get(i) : (RichTextMaker) invokeI.objValue;
        }

        public void b(int i, RichTextMaker<?> richTextMaker) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, richTextMaker) == null) {
                this.a.put(i, richTextMaker);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755739523, "Lcom/repackage/ef5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755739523, "Lcom/repackage/ef5;");
                return;
            }
        }
        b = new h();
        w();
        v();
    }

    public static void A(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (TextUtils.isEmpty(str) || !(currentActivity instanceof TbPageContextSupport)) {
                return;
            }
            UrlManager.getInstance().dealOneLink(((TbPageContextSupport) currentActivity).getPageContext(), new String[]{str});
        }
    }

    public static void B(String str, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, str, threadData) == null) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (TextUtils.isEmpty(str) || !(currentActivity instanceof TbPageContextSupport)) {
                return;
            }
            TbPageContextSupport tbPageContextSupport = (TbPageContextSupport) currentActivity;
            wz4 wz4Var = new wz4();
            wz4Var.a = str;
            if (threadData != null) {
                wz4Var.b = threadData.getResource();
                wz4Var.c = threadData.getPbTitle();
            }
            hc5.h(wz4Var);
            UrlManager.getInstance().dealOneLink(tbPageContextSupport.getPageContext(), new String[]{wz4Var.a, wz4Var.c});
        }
    }

    public static SpannableStringBuilder C(ThreadData threadData, List<PbContent> list, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, threadData, list, str)) == null) ? D(threadData, list, str, null) : (SpannableStringBuilder) invokeLLL.objValue;
    }

    public static SpannableStringBuilder D(ThreadData threadData, List<PbContent> list, String str, @Nullable List<nf5> list2) {
        InterceptResult invokeLLLL;
        int size;
        Pair<CharSequence, nf5> p;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, threadData, list, str, list2)) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (ListUtils.isEmpty(list)) {
                if (str == null) {
                    str = "";
                }
                spannableStringBuilder.append((CharSequence) str);
            } else if (list != null && (size = list.size()) > 0) {
                for (int i = 0; i < size; i++) {
                    PbContent pbContent = list.get(i);
                    if (pbContent != null && (!TextUtils.isEmpty(pbContent.text) || !TextUtils.isEmpty(i(pbContent)))) {
                        int f2 = f(pbContent.type);
                        CharSequence charSequence = null;
                        if (f2 == 35 && (p = p(f2, threadData, pbContent.tiebaplus_info)) != null) {
                            charSequence = p.first;
                            uc5.b(list2);
                            list2.add(p.second);
                        }
                        if (charSequence == null) {
                            charSequence = n(threadData, pbContent);
                        }
                        if (charSequence != null) {
                            spannableStringBuilder.append(charSequence);
                        }
                    }
                }
            }
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeLLLL.objValue;
    }

    public static SpannableStringBuilder E(List<PbContent> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, list)) == null) ? F(list, "") : (SpannableStringBuilder) invokeL.objValue;
    }

    public static SpannableStringBuilder F(List<PbContent> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, list, str)) == null) ? C(null, list, str) : (SpannableStringBuilder) invokeLL.objValue;
    }

    public static SpannableStringBuilder G(List<PbContent> list, List<HeadItem> list2, boolean z, @Nullable ThreadData threadData, @Nullable List<nf5> list3) {
        InterceptResult invokeCommon;
        int size;
        CharSequence charSequence;
        char c2;
        Pair<CharSequence, nf5> p;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{list, list2, Boolean.valueOf(z), threadData, list3})) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (ListUtils.isEmpty(list)) {
                spannableStringBuilder.append((CharSequence) "");
            } else if (list != null && (size = list.size()) > 0) {
                for (int i = 0; i < size; i++) {
                    PbContent pbContent = list.get(i);
                    if (pbContent != null && (!TextUtils.isEmpty(pbContent.text) || !TextUtils.isEmpty(i(pbContent)))) {
                        int f2 = f(pbContent.type);
                        SpannableStringBuilder spannableStringBuilder2 = null;
                        if (f2 != 35 || (p = p(f2, threadData, pbContent.tiebaplus_info)) == null) {
                            charSequence = null;
                        } else {
                            charSequence = p.first;
                            uc5.b(list3);
                            list3.add(p.second);
                        }
                        if (charSequence == null) {
                            charSequence = n(threadData, pbContent);
                        }
                        if (i != 0 || list2 == null) {
                            c2 = 65535;
                        } else {
                            spannableStringBuilder2 = e(list2);
                            c2 = f2 == 16 ? (char) 1 : (char) 0;
                        }
                        if (c2 == 65535) {
                            if (charSequence != null) {
                                spannableStringBuilder.append(charSequence);
                            }
                        } else if (c2 == 0) {
                            if (spannableStringBuilder2 != null) {
                                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                            }
                            if (charSequence != null) {
                                spannableStringBuilder.append(charSequence);
                            }
                        } else {
                            if (charSequence != null) {
                                spannableStringBuilder.append(charSequence);
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
        return (SpannableStringBuilder) invokeCommon.objValue;
    }

    public static SpannableStringBuilder d(ItemStarData itemStarData) {
        InterceptResult invokeL;
        List<ItemStarData.SingleItemStar> list;
        int count;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, itemStarData)) == null) {
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
                spannableStringBuilder.append((CharSequence) q(i2, false));
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
                        spannableStringBuilder.append((CharSequence) q(i, false));
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

    public static SpannableStringBuilder e(List<HeadItem> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, list)) == null) {
            ItemStarData itemStarData = new ItemStarData();
            itemStarData.parseProto(list);
            return d(itemStarData);
        }
        return (SpannableStringBuilder) invokeL.objValue;
    }

    public static int f(Integer num) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, num)) == null) {
            int intValue = num.intValue();
            if (intValue != 13) {
                if (intValue != 14) {
                    if (intValue != 18) {
                        if (intValue != 20) {
                            if (intValue != 27) {
                                if (intValue != 1282) {
                                    switch (intValue) {
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
                                            switch (intValue) {
                                                case 8:
                                                    return 128;
                                                case 9:
                                                    return 256;
                                                case 10:
                                                    return 512;
                                                case 11:
                                                    return 17;
                                                default:
                                                    switch (intValue) {
                                                        case 30:
                                                        case 31:
                                                        case 32:
                                                        case 33:
                                                            return 1;
                                                        default:
                                                            switch (intValue) {
                                                                case 35:
                                                                    return 35;
                                                                case 36:
                                                                    return 36;
                                                                case 37:
                                                                    return 37;
                                                                default:
                                                                    return 0;
                                                            }
                                                    }
                                            }
                                    }
                                }
                                return 1282;
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
        return invokeL.intValue;
    }

    public static void g(StatisticItem statisticItem, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, null, statisticItem, threadData) == null) {
            if (threadData.isVideoThreadType()) {
                statisticItem.param("obj_type", 2);
            } else if (threadData.isLinkThread()) {
                statisticItem.param("obj_type", 4);
            } else if (threadData.isShareThread) {
                statisticItem.param("obj_type", 5);
            } else if (threadData.isBJHArticleThreadType()) {
                statisticItem.param("obj_type", 6);
            } else if (threadData.isBJHNormalThreadType()) {
                statisticItem.param("obj_type", 7);
            } else if (threadData.isBJHVideoThreadType()) {
                statisticItem.param("obj_type", 8);
            } else if (threadData.isBJHVideoDynamicThreadType()) {
                statisticItem.param("obj_type", 9);
            } else if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                statisticItem.param("obj_type", 1);
            }
        }
    }

    public static SpannableString h(ThreadData threadData, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65551, null, threadData, str, str2)) == null) ? m(threadData, 16, str, str2) : (SpannableString) invokeLLL.objValue;
    }

    @NonNull
    public static final String i(@NonNull PbContent pbContent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, pbContent)) == null) {
            TiebaPlusInfo tiebaPlusInfo = pbContent.tiebaplus_info;
            return tiebaPlusInfo != null ? tiebaPlusInfo.desc : "";
        }
        return (String) invokeL.objValue;
    }

    public static SpannableString j(String str) {
        InterceptResult invokeL;
        int b2;
        String str2;
        f35.a c2;
        double d2;
        int a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, str)) == null) {
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
            df5 df5Var = new df5(TbadkCoreApplication.getInst().getContext(), b2);
            if (c2 != null) {
                if (str != null && str.startsWith("bearchildren_")) {
                    d2 = 0.25d;
                    a2 = c2.a();
                } else {
                    d2 = 0.4d;
                    a2 = c2.a();
                }
                int i = (int) (a2 * d2);
                df5Var.setBounds(new Rect(0, 0, i, i));
            } else {
                df5Var.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new sd5(df5Var, 2), 0, str2.length(), 33);
            return spannableString;
        }
        return (SpannableString) invokeL.objValue;
    }

    public static SpannableString k(ThreadData threadData, int i, String str, String str2, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65554, null, new Object[]{threadData, Integer.valueOf(i), str, str2, str3})) == null) ? r(threadData, i, str, str2, 0, str3) : (SpannableString) invokeCommon.objValue;
    }

    public static SpannableString l(ThreadData threadData, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65555, null, threadData, str, str2, str3)) == null) ? k(threadData, 39, str, str2, str3) : (SpannableString) invokeLLLL.objValue;
    }

    public static SpannableString m(ThreadData threadData, int i, String str, String str2) {
        InterceptResult invokeLILL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLILL = interceptable.invokeLILL(65556, null, threadData, i, str, str2)) == null) ? r(threadData, i, str, str2, 0, null) : (SpannableString) invokeLILL.objValue;
    }

    public static CharSequence n(ThreadData threadData, PbContent pbContent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65557, null, threadData, pbContent)) == null) {
            int f2 = f(pbContent.type);
            if (f2 != 2) {
                if (f2 != 4) {
                    if (f2 == 16) {
                        return h(threadData, pbContent.text, String.valueOf(pbContent.uid));
                    }
                    if (f2 != 18) {
                        if (f2 == 35) {
                            return new SpannableString("");
                        }
                        if (f2 == 39) {
                            String str = pbContent.text;
                            return l(threadData, str, pbContent.item_id + "", pbContent.item_forum_name);
                        } else if (f2 != 1282) {
                            String str2 = pbContent.text;
                            return new SpannableString(str2 != null ? str2 : "");
                        }
                    }
                    if (threadData != null && pbContent != null) {
                        z45 f3 = z45.f(threadData, pbContent);
                        f3.b(HotTopicStat.Locate.THREAD_CARD);
                        f3.a(f2 == 1282);
                        return o(f3);
                    }
                }
                return j(pbContent.text);
            }
            return m(threadData, 2, pbContent.text, pbContent.link);
        }
        return (CharSequence) invokeLL.objValue;
    }

    public static SpannableString o(@NonNull z45 z45Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, z45Var)) == null) {
            SpannableString b2 = b.a(18).b(18, z45Var.j().text, z45Var);
            SpecHotTopicHelper.addSpecTopic(z45Var.l(), b2, b2.toString(), 0);
            return b2;
        }
        return (SpannableString) invokeL.objValue;
    }

    @Nullable
    public static Pair<CharSequence, nf5> p(int i, @Nullable ThreadData threadData, @Nullable TiebaPlusInfo tiebaPlusInfo) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65559, null, i, threadData, tiebaPlusInfo)) == null) {
            if (threadData == null || !TiePlusHelper.j(tiebaPlusInfo) || TextUtils.isEmpty(tiebaPlusInfo.desc)) {
                return null;
            }
            nf5 c2 = nf5.c(i, tiebaPlusInfo, threadData);
            RichTextMaker a2 = b.a(i);
            int intValue = tiebaPlusInfo.jump_type.intValue();
            if (intValue != 2) {
                if (intValue != 3) {
                    if (intValue == 5) {
                        a2.h(R.drawable.obfuscated_res_0x7f080804);
                    } else if (intValue == 6) {
                        a2.h(R.drawable.obfuscated_res_0x7f080f56);
                    } else if (intValue != 7) {
                        a2.h(R.drawable.obfuscated_res_0x7f08096c);
                    }
                }
                a2.h(R.drawable.obfuscated_res_0x7f0809f0);
            } else {
                a2.h(R.drawable.obfuscated_res_0x7f080964);
            }
            return Pair.create(a2.b(i, tiebaPlusInfo.desc, c2), c2);
        }
        return (Pair) invokeILL.objValue;
    }

    public static SpannableString q(int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65560, null, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            if (i < 0) {
                return null;
            }
            int i2 = i > 5 ? 5 : i;
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds10);
            int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds36);
            int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.tbds13);
            SpannableString spannableString = new SpannableString(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0979));
            spannableString.setSpan(new dv4(i2, dimenPixelSize, dimenPixelSize2, dimenPixelSize3, 0, z), 0, spannableString.length(), 33);
            return spannableString;
        }
        return (SpannableString) invokeCommon.objValue;
    }

    public static SpannableString r(ThreadData threadData, int i, String str, String str2, int i2, String str3) {
        InterceptResult invokeCommon;
        SpannableString spannableString;
        ff5 gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65561, null, new Object[]{threadData, Integer.valueOf(i), str, str2, Integer.valueOf(i2), str3})) == null) {
            String str4 = str;
            if (str4 != null) {
                boolean z = i == 2 && x(str, str2);
                boolean z2 = i == 39;
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
                if (i == 18) {
                    gVar = new c(i, str2, str2);
                } else if (i == 1282) {
                    gVar = new d(i, str2);
                } else if (i == 16) {
                    gVar = new e(i, str2, threadData, str2);
                } else if (i == 39) {
                    gVar = new f(i, str2, str2, threadData, str3);
                } else {
                    gVar = new g(i, str2, str2);
                }
                gVar.k(i2);
                if (i2 == 1) {
                    gVar.j(R.color.CAM_X0109);
                } else {
                    gVar.j(-1);
                }
                if (z) {
                    EMRichTextAnyIconSpan eMRichTextAnyIconSpan = new EMRichTextAnyIconSpan(R.drawable.obfuscated_res_0x7f08096c, R.color.CAM_X0304, EMRichTextAnyIconSpan.IconType.WEBP);
                    eMRichTextAnyIconSpan.c(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
                    spannableString2.setSpan(eMRichTextAnyIconSpan, 0, 1, 33);
                    spannableString2.setSpan(gVar, 1, (str5.length() + 1) - 1, 33);
                    return spannableString2;
                } else if (z2) {
                    EMRichTextAnyIconSpan eMRichTextAnyIconSpan2 = new EMRichTextAnyIconSpan(R.drawable.obfuscated_res_0x7f080a9c, R.color.CAM_X0304, EMRichTextAnyIconSpan.IconType.WEBP);
                    eMRichTextAnyIconSpan2.f(UtilHelper.getDimenPixelSize(R.dimen.M_W_X006));
                    spannableString2.setSpan(eMRichTextAnyIconSpan2, str5.length() - 1, str5.length() + 1, 33);
                    spannableString2.setSpan(gVar, 0, str5.length() - 1, 33);
                    if (a != threadData.getTid()) {
                        a = threadData.getTid();
                        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_ITEM_THROUGH_EXPOSURE);
                        statisticItem.param("tid", a);
                        statisticItem.param("obj_locate", threadData.isFromHomPage ? 1 : 2);
                        TiebaStatic.log(statisticItem);
                        return spannableString2;
                    }
                    return spannableString2;
                } else {
                    spannableString2.setSpan(gVar, 0, str5.length() - 1, 33);
                    return spannableString2;
                }
            }
            return null;
        }
        return (SpannableString) invokeCommon.objValue;
    }

    @Deprecated
    public static SpannableString s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65562, null)) == null) ? new SpannableString("") : (SpannableString) invokeV.objValue;
    }

    public static boolean t(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, threadData)) == null) {
            if (threadData == null) {
                return false;
            }
            List<PbContent> firstFloorList = threadData.getFirstFloorList();
            if (!ListUtils.isEmpty(firstFloorList)) {
                for (int count = ListUtils.getCount(firstFloorList) - 1; count >= 0; count--) {
                    if (firstFloorList.get(count).type.intValue() == 37) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean u(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, postData)) == null) {
            if (postData != null && postData.P() != null) {
                ArrayList<TbRichTextData> A = postData.P().A();
                if (!ListUtils.isEmpty(A)) {
                    for (int count = ListUtils.getCount(A) - 1; count >= 0; count--) {
                        if (A.get(count).getType() == 37) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65565, null) == null) {
            b.b(18, new a());
        }
    }

    public static void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65566, null) == null) {
            b.b(35, new b(RichTextMaker.IconPos.START, R.drawable.obfuscated_res_0x7f08096c, R.color.CAM_X0304, R.dimen.M_W_X002));
        }
    }

    public static boolean x(@NonNull String str, @NonNull String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65567, null, str, str2)) == null) {
            if (ni.isEmpty(str) || ni.isEmpty(str2)) {
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

    public static void y(ThreadData threadData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65568, null, threadData, str) == null) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (TextUtils.isEmpty(str) || currentActivity == null) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(currentActivity, str, null)));
            if (threadData != null) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_DYNAMIC_CARD_CLICK);
                if (threadData.isFromConcern()) {
                    statisticItem = new StatisticItem(TbadkCoreStatisticKey.CONCERN_TAB_THREAD_CLICK);
                    statisticItem.param("obj_source", 1);
                    g(statisticItem, threadData);
                } else if (threadData.isFromHomPage) {
                    statisticItem.param("obj_source", 2);
                    if (threadData.getBaijiahaoData() != null) {
                        statisticItem.param("obj_type", threadData.getBaijiahaoData().oriUgcType);
                    }
                } else {
                    statisticItem.param("obj_source", 3);
                    if (threadData.getBaijiahaoData() != null) {
                        statisticItem.param("obj_type", threadData.getBaijiahaoData().oriUgcType);
                    }
                }
                statisticItem.param("obj_locate", 5);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public static void z(String str, ThreadData threadData, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65569, null, str, threadData, str2) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_ITEM_THROUGH_CLICK);
            statisticItem.param("tid", threadData.getTid());
            statisticItem.param("obj_locate", threadData.isFromHomPage ? 1 : 2);
            statisticItem.param("obj_type", str);
            TiebaStatic.log(statisticItem);
            ItemClickJumpUtil.itemClickJump(str2, str, 8, 8);
        }
    }
}
