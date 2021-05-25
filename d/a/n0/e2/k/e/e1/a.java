package d.a.n0.e2.k.e.e1;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.SparseArray;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import d.a.c.a.f;
import d.a.m0.r.s.a;
import d.a.m0.r.s.h;
import d.a.m0.r.s.l;
import d.a.n0.e2.h.e;
import d.a.n0.e2.h.r;
import d.a.n0.e2.k.e.r0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class a {
    public static boolean a(List<h> list, l lVar, PostData postData, PbModel pbModel) {
        if (list != null && postData != null && pbModel != null && pbModel.y0() != null) {
            e y0 = pbModel.y0();
            if (y0.b0() && TbadkCoreApplication.isLogin() && !j(postData) && !y0.a0()) {
                h hVar = new h(9, TbadkCoreApplication.getInst().getString(R.string.block_user), lVar);
                list.add(hVar);
                d.a.n0.o3.a.e(hVar.f50254d, postData);
                return true;
            }
        }
        return false;
    }

    public static List<h> b(List<h> list, AgreeData agreeData, SparseArray<Object> sparseArray, l lVar) {
        if (list == null) {
            list = new ArrayList<>();
        }
        ArrayList arrayList = new ArrayList();
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 2) {
                h hVar = new h(-1, r0.g(R.string.c_agreeed, new Object[0]), lVar);
                hVar.f50254d.setTag(sparseArray);
                arrayList.add(hVar);
                if (sparseArray == null || sparseArray.get(R.id.pb_dialog_item_isugc) == null || !((Boolean) sparseArray.get(R.id.pb_dialog_item_isugc)).booleanValue()) {
                    h hVar2 = new h(-2, r0.g(R.string.c_disagree, new Object[0]), lVar);
                    hVar2.f50254d.setTag(sparseArray);
                    arrayList.add(hVar2);
                }
            } else {
                h hVar3 = new h(-1, r0.g(R.string.c_agree, new Object[0]), lVar);
                hVar3.f50254d.setTag(sparseArray);
                arrayList.add(hVar3);
                if (sparseArray == null || sparseArray.get(R.id.pb_dialog_item_isugc) == null || !((Boolean) sparseArray.get(R.id.pb_dialog_item_isugc)).booleanValue()) {
                    h hVar4 = new h(-2, r0.g(R.string.c_disagreeed, new Object[0]), lVar);
                    hVar4.f50254d.setTag(sparseArray);
                    arrayList.add(hVar4);
                }
            }
        } else {
            h hVar5 = new h(-1, r0.g(R.string.c_agree, new Object[0]), lVar);
            hVar5.f50254d.setTag(sparseArray);
            arrayList.add(hVar5);
            if (sparseArray == null || sparseArray.get(R.id.pb_dialog_item_isugc) == null || !((Boolean) sparseArray.get(R.id.pb_dialog_item_isugc)).booleanValue()) {
                h hVar6 = new h(-2, r0.g(R.string.c_disagree, new Object[0]), lVar);
                hVar6.f50254d.setTag(sparseArray);
                arrayList.add(hVar6);
            }
        }
        h hVar7 = new h(-3, r0.g(R.string.reply, new Object[0]), lVar);
        hVar7.f50254d.setTag(sparseArray);
        arrayList.add(hVar7);
        h hVar8 = new h(-4, r0.g(R.string.share, new Object[0]), lVar);
        hVar8.f50254d.setTag(sparseArray);
        arrayList.add(hVar8);
        list.addAll(0, arrayList);
        return list;
    }

    public static List<h> c(List<h> list, AgreeData agreeData, SparseArray<Object> sparseArray, l lVar) {
        if (list == null) {
            list = new ArrayList<>();
        }
        ArrayList arrayList = new ArrayList();
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 2) {
                if (sparseArray == null || sparseArray.get(R.id.pb_dialog_item_isugc) == null || !((Boolean) sparseArray.get(R.id.pb_dialog_item_isugc)).booleanValue()) {
                    h hVar = new h(-2, r0.g(R.string.action_dislike, new Object[0]), lVar);
                    hVar.f50254d.setTag(sparseArray);
                    arrayList.add(hVar);
                }
            } else if (sparseArray == null || sparseArray.get(R.id.pb_dialog_item_isugc) == null || !((Boolean) sparseArray.get(R.id.pb_dialog_item_isugc)).booleanValue()) {
                h hVar2 = new h(-2, r0.g(R.string.c_disagreeed, new Object[0]), lVar);
                hVar2.f50254d.setTag(sparseArray);
                arrayList.add(hVar2);
            }
        } else if (sparseArray == null || sparseArray.get(R.id.pb_dialog_item_isugc) == null || !((Boolean) sparseArray.get(R.id.pb_dialog_item_isugc)).booleanValue()) {
            h hVar3 = new h(-2, r0.g(R.string.action_dislike, new Object[0]), lVar);
            hVar3.f50254d.setTag(sparseArray);
            arrayList.add(hVar3);
        }
        h hVar4 = new h(-3, r0.g(R.string.reply, new Object[0]), lVar);
        hVar4.f50254d.setTag(sparseArray);
        arrayList.add(0, hVar4);
        h hVar5 = new h(-4, r0.g(R.string.share, new Object[0]), lVar);
        hVar5.f50254d.setTag(sparseArray);
        arrayList.add(1, hVar5);
        list.addAll(0, arrayList);
        return list;
    }

    public static void d(Activity activity, @Nullable f<?> fVar, a.e eVar, a.e eVar2) {
        int i2 = R.string.del_post_confirm;
        int i3 = R.string.dialog_ok;
        int i4 = R.string.dialog_cancel;
        d.a.m0.r.s.a aVar = new d.a.m0.r.s.a(activity);
        aVar.setMessageId(i2);
        aVar.setPositiveButton(i3, eVar);
        aVar.setNegativeButton(i4, eVar2);
        aVar.setCancelable(true);
        aVar.create(fVar);
        aVar.show();
    }

    public static List<h> e(List<h> list) {
        if (list == null) {
            return list;
        }
        for (h hVar : list) {
            hVar.l(g(hVar));
        }
        return list;
    }

    public static SpannableStringBuilder f(PostData postData) {
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

    public static Drawable g(h hVar) {
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

    public static boolean h(PbModel pbModel) {
        return (pbModel == null || pbModel.y0() == null || !pbModel.y0().b0()) ? false : true;
    }

    public static boolean i(r rVar) {
        return rVar != null && rVar.q();
    }

    public static boolean j(PostData postData) {
        return (postData == null || postData.t() == null || StringUtils.isNull(postData.t().getUserId()) || !postData.t().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
    }

    public static List<h> k(List<h> list, boolean z) {
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

    public static boolean l(TextView textView, PostData postData, r rVar) {
        if (textView != null && rVar != null && postData != null) {
            if (rVar.q() && TbadkCoreApplication.isLogin() && !j(postData) && !rVar.p()) {
                d.a.n0.o3.a.e(textView, postData);
                textView.setVisibility(0);
                return true;
            }
            textView.setVisibility(8);
        }
        return false;
    }

    public static int m(int i2) {
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

    public static SpannableString n(String str, int i2) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i2), 0, str.length(), 33);
        return spannableString;
    }
}
