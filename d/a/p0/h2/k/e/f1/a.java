package d.a.p0.h2.k.e.f1;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.SparseArray;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import d.a.c.a.f;
import d.a.o0.r.s.a;
import d.a.o0.r.s.h;
import d.a.o0.r.s.l;
import d.a.p0.h2.h.e;
import d.a.p0.h2.h.r;
import d.a.p0.h2.k.e.r0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(List<h> list, l lVar, PostData postData, PbModel pbModel) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, list, lVar, postData, pbModel)) == null) {
            if (list != null && postData != null && pbModel != null && pbModel.D0() != null) {
                e D0 = pbModel.D0();
                if (D0.f0() && TbadkCoreApplication.isLogin() && !j(postData) && !D0.e0()) {
                    h hVar = new h(9, TbadkCoreApplication.getInst().getString(R.string.block_user), lVar);
                    list.add(hVar);
                    d.a.p0.r3.a.e(hVar.f52897d, postData);
                    return true;
                }
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public static List<h> b(List<h> list, AgreeData agreeData, SparseArray<Object> sparseArray, l lVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, list, agreeData, sparseArray, lVar)) == null) {
            if (list == null) {
                list = new ArrayList<>();
            }
            ArrayList arrayList = new ArrayList();
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 2) {
                    h hVar = new h(-1, r0.g(R.string.c_agreeed, new Object[0]), lVar);
                    hVar.f52897d.setTag(sparseArray);
                    arrayList.add(hVar);
                    if (sparseArray == null || sparseArray.get(R.id.pb_dialog_item_isugc) == null || !((Boolean) sparseArray.get(R.id.pb_dialog_item_isugc)).booleanValue()) {
                        h hVar2 = new h(-2, r0.g(R.string.c_disagree, new Object[0]), lVar);
                        hVar2.f52897d.setTag(sparseArray);
                        arrayList.add(hVar2);
                    }
                } else {
                    h hVar3 = new h(-1, r0.g(R.string.c_agree, new Object[0]), lVar);
                    hVar3.f52897d.setTag(sparseArray);
                    arrayList.add(hVar3);
                    if (sparseArray == null || sparseArray.get(R.id.pb_dialog_item_isugc) == null || !((Boolean) sparseArray.get(R.id.pb_dialog_item_isugc)).booleanValue()) {
                        h hVar4 = new h(-2, r0.g(R.string.c_disagreeed, new Object[0]), lVar);
                        hVar4.f52897d.setTag(sparseArray);
                        arrayList.add(hVar4);
                    }
                }
            } else {
                h hVar5 = new h(-1, r0.g(R.string.c_agree, new Object[0]), lVar);
                hVar5.f52897d.setTag(sparseArray);
                arrayList.add(hVar5);
                if (sparseArray == null || sparseArray.get(R.id.pb_dialog_item_isugc) == null || !((Boolean) sparseArray.get(R.id.pb_dialog_item_isugc)).booleanValue()) {
                    h hVar6 = new h(-2, r0.g(R.string.c_disagree, new Object[0]), lVar);
                    hVar6.f52897d.setTag(sparseArray);
                    arrayList.add(hVar6);
                }
            }
            h hVar7 = new h(-3, r0.g(R.string.reply, new Object[0]), lVar);
            hVar7.f52897d.setTag(sparseArray);
            arrayList.add(hVar7);
            h hVar8 = new h(-4, r0.g(R.string.share, new Object[0]), lVar);
            hVar8.f52897d.setTag(sparseArray);
            arrayList.add(hVar8);
            list.addAll(0, arrayList);
            return list;
        }
        return (List) invokeLLLL.objValue;
    }

    public static List<h> c(List<h> list, AgreeData agreeData, SparseArray<Object> sparseArray, l lVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, list, agreeData, sparseArray, lVar)) == null) {
            if (list == null) {
                list = new ArrayList<>();
            }
            ArrayList arrayList = new ArrayList();
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 2) {
                    if (sparseArray == null || sparseArray.get(R.id.pb_dialog_item_isugc) == null || !((Boolean) sparseArray.get(R.id.pb_dialog_item_isugc)).booleanValue()) {
                        h hVar = new h(-2, r0.g(R.string.action_dislike, new Object[0]), lVar);
                        hVar.f52897d.setTag(sparseArray);
                        arrayList.add(hVar);
                    }
                } else if (sparseArray == null || sparseArray.get(R.id.pb_dialog_item_isugc) == null || !((Boolean) sparseArray.get(R.id.pb_dialog_item_isugc)).booleanValue()) {
                    h hVar2 = new h(-2, r0.g(R.string.c_disagreeed, new Object[0]), lVar);
                    hVar2.f52897d.setTag(sparseArray);
                    arrayList.add(hVar2);
                }
            } else if (sparseArray == null || sparseArray.get(R.id.pb_dialog_item_isugc) == null || !((Boolean) sparseArray.get(R.id.pb_dialog_item_isugc)).booleanValue()) {
                h hVar3 = new h(-2, r0.g(R.string.action_dislike, new Object[0]), lVar);
                hVar3.f52897d.setTag(sparseArray);
                arrayList.add(hVar3);
            }
            h hVar4 = new h(-3, r0.g(R.string.reply, new Object[0]), lVar);
            hVar4.f52897d.setTag(sparseArray);
            arrayList.add(0, hVar4);
            h hVar5 = new h(-4, r0.g(R.string.share, new Object[0]), lVar);
            hVar5.f52897d.setTag(sparseArray);
            arrayList.add(1, hVar5);
            list.addAll(0, arrayList);
            return list;
        }
        return (List) invokeLLLL.objValue;
    }

    public static void d(Activity activity, @Nullable f<?> fVar, a.e eVar, a.e eVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65539, null, activity, fVar, eVar, eVar2) == null) {
            int i2 = R.string.del_post_confirm;
            int i3 = R.string.dialog_ok;
            int i4 = R.string.dialog_cancel;
            d.a.o0.r.s.a aVar = new d.a.o0.r.s.a(activity);
            aVar.setMessageId(i2);
            aVar.setPositiveButton(i3, eVar);
            aVar.setNegativeButton(i4, eVar2);
            aVar.setCancelable(true);
            aVar.create(fVar);
            aVar.show();
        }
    }

    public static List<h> e(List<h> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, list)) == null) {
            if (list == null) {
                return list;
            }
            for (h hVar : list) {
                hVar.l(g(hVar));
            }
            return list;
        }
        return (List) invokeL.objValue;
    }

    public static SpannableStringBuilder f(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, postData)) == null) {
            if (postData == null) {
                return null;
            }
            String tbRichText = postData.K() != null ? postData.K().toString() : "";
            SpannableString n = n(postData.t().getName_show() + ZeusCrashHandler.NAME_SEPERATOR, SkinManager.getColor(R.color.CAM_X0109));
            SpannableString n2 = n(tbRichText, SkinManager.getColor(R.color.CAM_X0107));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) n);
            spannableStringBuilder.append((CharSequence) n2);
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeL.objValue;
    }

    public static Drawable g(h hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, hVar)) == null) {
            switch (hVar.f()) {
                case -4:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_share30, SkinManager.getColor(R.color.CAM_X0107), null);
                case -3:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_comment30, SkinManager.getColor(R.color.CAM_X0107), null);
                case -2:
                    if (r0.g(R.string.c_disagree, new Object[0]).equals(hVar.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_dislike30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_disliked30, SkinManager.getColor(R.color.CAM_X0107), null);
                case -1:
                    if (r0.g(R.string.c_agree, new Object[0]).equals(hVar.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_like30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_liked30, SkinManager.getColor(R.color.CAM_X0301), null);
                case 0:
                default:
                    return null;
                case 1:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_expression30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 2:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_save30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 3:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_copy30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 4:
                    if (r0.g(R.string.mark, new Object[0]).equals(hVar.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_collect30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_collected30, SkinManager.getColor(R.color.CAM_X0305), null);
                case 5:
                    if (r0.g(R.string.report_text, new Object[0]).equals(hVar.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_report30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (r0.g(R.string.mute_option, new Object[0]).equals(hVar.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_nospeakingset30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return null;
                case 6:
                    if (r0.g(R.string.report_text, new Object[0]).equals(hVar.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_report30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (r0.g(R.string.delete, new Object[0]).equals(hVar.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_delete30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return null;
                case 7:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_administration30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 8:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_hide30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 9:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_block30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 10:
                    if (r0.g(R.string.delete_post, new Object[0]).equals(hVar.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_delete30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (r0.g(R.string.delete, new Object[0]).equals(hVar.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_delete30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return null;
                case 11:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_block30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 12:
                    if (r0.g(R.string.mute, new Object[0]).equals(hVar.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_nospeaking30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (r0.g(R.string.un_mute, new Object[0]).equals(hVar.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_nospeakinged30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return null;
            }
        }
        return (Drawable) invokeL.objValue;
    }

    public static boolean h(PbModel pbModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, pbModel)) == null) ? (pbModel == null || pbModel.D0() == null || !pbModel.D0().f0()) ? false : true : invokeL.booleanValue;
    }

    public static boolean i(r rVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, rVar)) == null) ? rVar != null && rVar.q() : invokeL.booleanValue;
    }

    public static boolean j(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, postData)) == null) ? (postData == null || postData.t() == null || StringUtils.isNull(postData.t().getUserId()) || !postData.t().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true : invokeL.booleanValue;
    }

    public static List<h> k(List<h> list, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65546, null, list, z)) == null) {
            if (list != null && !z) {
                Iterator<h> it = list.iterator();
                while (it.hasNext()) {
                    h next = it.next();
                    if (next.f() == 2 || next.f() == 1 || next.f() == 3) {
                        it.remove();
                    }
                }
            }
            return list;
        }
        return (List) invokeLZ.objValue;
    }

    public static boolean l(TextView textView, PostData postData, r rVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65547, null, textView, postData, rVar)) == null) {
            if (textView != null && rVar != null && postData != null) {
                if (rVar.q() && TbadkCoreApplication.isLogin() && !j(postData) && !rVar.p()) {
                    d.a.p0.r3.a.e(textView, postData);
                    textView.setVisibility(0);
                    return true;
                }
                textView.setVisibility(8);
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static int m(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65548, null, i2)) == null) {
            if (i2 != -4) {
                if (i2 != -3) {
                    if (i2 != -2) {
                        if (i2 != -1) {
                            switch (i2) {
                                case 4:
                                    return 5;
                                case 5:
                                    return 7;
                                case 6:
                                    return 6;
                                case 7:
                                    return 9;
                                case 8:
                                    return 8;
                                default:
                                    return 0;
                            }
                        }
                        return 1;
                    }
                    return 2;
                }
                return 3;
            }
            return 4;
        }
        return invokeI.intValue;
    }

    public static SpannableString n(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65549, null, str, i2)) == null) {
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new ForegroundColorSpan(i2), 0, str.length(), 33);
            return spannableString;
        }
        return (SpannableString) invokeLI.objValue;
    }
}
