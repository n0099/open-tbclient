package com.example.shareplugin;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.c.f;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class SharepluginPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {
    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        new MethodChannel(flutterPluginBinding.getFlutterEngine().getDartExecutor(), "shareplugin").setMethodCallHandler(new SharepluginPlugin());
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        if (methodCall.method.equals("getPlatformVersion")) {
            result.success("Android " + Build.VERSION.RELEASE);
        } else if (methodCall.method.equals("shareThread")) {
            try {
                JSONObject jSONObject = new JSONObject((Map) methodCall.argument(MapController.ITEM_LAYER_TAG));
                bz bzVar = new bz();
                bzVar.parserJson(jSONObject);
                showShareDialog(bzVar);
                result.success("");
            } catch (Exception e) {
                BdLog.e(e);
            }
        } else if (methodCall.method.equals("shareGameItemDetails")) {
            try {
                showShareDetailsDialog((String) methodCall.argument("url"), (String) methodCall.argument("itemId"), (String) methodCall.argument("itemName"), "1".equals(methodCall.argument("can_repost")));
                result.success("");
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        } else {
            result.notImplemented();
        }
    }

    private void showShareDetailsDialog(String str, String str2, String str3, boolean z) {
        if (str != null) {
            ShareItem shareItem = new ShareItem();
            shareItem.linkUrl = str;
            shareItem.extData = str2;
            shareItem.title = str3;
            shareItem.fxg = true;
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.fxp);
            bundle.putInt("obj_type", shareItem.fxt);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.eWH);
            shareItem.ae(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(TbadkCoreApplication.getInst().getCurrentActivity(), shareItem, true);
            if (z) {
                f.cwf().b(shareDialogConfig);
                return;
            }
            shareDialogConfig.isCopyLink = true;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0249  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void showShareDialog(bz bzVar) {
        String tid;
        String str;
        boolean z;
        Uri parse;
        String str2;
        String format;
        String str3;
        if (bzVar != null) {
            String valueOf = String.valueOf(bzVar.getFid());
            String brv = bzVar.brv();
            if (bzVar.eVM != null) {
                valueOf = bzVar.eVM.id;
                brv = bzVar.eVM.ori_fname;
            }
            String title = bzVar.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = bzVar.getAbstract();
            }
            if (bzVar.bqa()) {
                tid = bzVar.getBaijiahaoData().oriUgcTid;
                str = "?share=9105&fr=dshare&dtype=" + bzVar.getBaijiahaoData().oriUgcType + "&dvid=" + bzVar.getBaijiahaoData().oriUgcVid + "&nid=" + bzVar.getBaijiahaoData().oriUgcNid;
            } else {
                tid = bzVar.getTid();
                str = "?share=9105&fr=share";
            }
            String str4 = "http://tieba.baidu.com/p/" + tid + str;
            if (bzVar.brK() != null && bzVar.brK().user_info != null) {
                try {
                    if (TbConfig.HTTPS_LIVE_SHARE_PREFIX.contains("?")) {
                        str3 = "https://tieba.baidu.com/ala/share&uname=" + URLEncoder.encode(bzVar.brK().user_info.user_name, "utf-8");
                    } else {
                        str3 = "https://tieba.baidu.com/ala/share?uname=" + URLEncoder.encode(bzVar.brK().user_info.user_name, "utf-8");
                    }
                    z = false;
                    str4 = str3;
                } catch (Exception e) {
                    BdLog.e(e);
                }
                String shareImageUrl = getShareImageUrl(bzVar);
                parse = shareImageUrl != null ? null : Uri.parse(shareImageUrl);
                str2 = bzVar.getAbstract();
                String string = TbadkApplication.getInst().getResources().getString(R.string.share_content_tpl);
                String string2 = TbadkApplication.getInst().getResources().getString(R.string.default_share_content_tpl);
                if (bzVar.bqa() || bzVar.brr() == null) {
                    format = MessageFormat.format(string, title, str2);
                } else {
                    format = (TextUtils.isEmpty(bzVar.getTitle()) || TextUtils.isEmpty(str2)) ? MessageFormat.format(string2, bzVar.brr().getName_show(), TbadkApplication.getInst().getResources().getString(R.string.default_share_content_tpl_suffix)) : str2;
                }
                String cutString = at.cutString(title, 100);
                String cutString2 = at.cutString(format, 100);
                ShareItem shareItem = new ShareItem();
                shareItem.title = cutString;
                shareItem.content = cutString2;
                int stateThreadType = getStateThreadType(bzVar);
                if (!bzVar.bqa()) {
                    shareItem.readCount = -1L;
                    shareItem.fxm = cutString2;
                } else {
                    if (stateThreadType == 2 && bzVar.brI() != null) {
                        shareItem.readCount = bzVar.brI().play_count.intValue();
                    } else if (stateThreadType == 1) {
                        shareItem.readCount = bzVar.brj();
                    }
                    shareItem.fxm = str2;
                }
                shareItem.linkUrl = str4;
                shareItem.extData = tid;
                shareItem.fid = valueOf;
                shareItem.fName = brv;
                shareItem.tid = tid;
                shareItem.fxb = true;
                shareItem.eWH = 6;
                shareItem.fxo = 8;
                shareItem.fxt = stateThreadType;
                shareItem.fxp = 3;
                shareItem.fxq = getShareObjParam2(bzVar);
                if (parse != null) {
                    shareItem.imageUri = parse;
                }
                if (bzVar.bqa()) {
                    z = false;
                }
                shareItem.canShareBySmartApp = z;
                if (z) {
                    shareItem.fxD = bzVar.getShareImageUrl();
                }
                shareItem.fxw = OriginalThreadInfo.ShareInfo.generateShareInfo(bzVar);
                shareItem.fxx = ShareItem.ForwardInfo.generateForwardInfo(bzVar);
                TbadkCoreApplication.getInst().setShareItem(shareItem);
                Bundle bundle = new Bundle();
                bundle.putInt("obj_param1", shareItem.fxp);
                bundle.putInt("obj_type", shareItem.fxt);
                bundle.putString("fid", shareItem.fid);
                bundle.putString("tid", shareItem.tid);
                bundle.putInt("obj_source", shareItem.eWH);
                shareItem.ae(bundle);
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(TbadkCoreApplication.getInst().getCurrentActivity(), shareItem, true);
                boolean z2 = false;
                shareDialogConfig.setIsAlaLive((bzVar.getThreadType() != 49 || bzVar.getThreadType() == 60) ? true : true);
                shareDialogConfig.setFrom(ShareDialogConfig.From.PersonPolymeric);
                f.cwf().b(shareDialogConfig);
            }
            z = true;
            String shareImageUrl2 = getShareImageUrl(bzVar);
            if (shareImageUrl2 != null) {
            }
            str2 = bzVar.getAbstract();
            String string3 = TbadkApplication.getInst().getResources().getString(R.string.share_content_tpl);
            String string22 = TbadkApplication.getInst().getResources().getString(R.string.default_share_content_tpl);
            if (bzVar.bqa()) {
            }
            format = MessageFormat.format(string3, title, str2);
            String cutString3 = at.cutString(title, 100);
            String cutString22 = at.cutString(format, 100);
            ShareItem shareItem2 = new ShareItem();
            shareItem2.title = cutString3;
            shareItem2.content = cutString22;
            int stateThreadType2 = getStateThreadType(bzVar);
            if (!bzVar.bqa()) {
            }
            shareItem2.linkUrl = str4;
            shareItem2.extData = tid;
            shareItem2.fid = valueOf;
            shareItem2.fName = brv;
            shareItem2.tid = tid;
            shareItem2.fxb = true;
            shareItem2.eWH = 6;
            shareItem2.fxo = 8;
            shareItem2.fxt = stateThreadType2;
            shareItem2.fxp = 3;
            shareItem2.fxq = getShareObjParam2(bzVar);
            if (parse != null) {
            }
            if (bzVar.bqa()) {
            }
            shareItem2.canShareBySmartApp = z;
            if (z) {
            }
            shareItem2.fxw = OriginalThreadInfo.ShareInfo.generateShareInfo(bzVar);
            shareItem2.fxx = ShareItem.ForwardInfo.generateForwardInfo(bzVar);
            TbadkCoreApplication.getInst().setShareItem(shareItem2);
            Bundle bundle2 = new Bundle();
            bundle2.putInt("obj_param1", shareItem2.fxp);
            bundle2.putInt("obj_type", shareItem2.fxt);
            bundle2.putString("fid", shareItem2.fid);
            bundle2.putString("tid", shareItem2.tid);
            bundle2.putInt("obj_source", shareItem2.eWH);
            shareItem2.ae(bundle2);
            ShareDialogConfig shareDialogConfig2 = new ShareDialogConfig(TbadkCoreApplication.getInst().getCurrentActivity(), shareItem2, true);
            boolean z22 = false;
            shareDialogConfig2.setIsAlaLive((bzVar.getThreadType() != 49 || bzVar.getThreadType() == 60) ? true : true);
            shareDialogConfig2.setFrom(ShareDialogConfig.From.PersonPolymeric);
            f.cwf().b(shareDialogConfig2);
        }
    }

    private int getStateThreadType(bz bzVar) {
        if (bzVar != null) {
            if (bzVar.brt()) {
                return 4;
            }
            if (bzVar.bro() == 1) {
                return 3;
            }
            if (bzVar.bpY()) {
                return 5;
            }
            if (bzVar.bpZ()) {
                return 6;
            }
            if (bzVar.btp()) {
                return 7;
            }
            if (bzVar.btq()) {
                return 8;
            }
            if (!bzVar.isShareThread || bzVar.eVB == null) {
                return bzVar.bsM() ? 2 : 1;
            }
            return 9;
        }
        return 0;
    }

    private int getShareObjParam2(bz bzVar) {
        if (bzVar == null) {
            return 0;
        }
        if (bzVar.bpY()) {
            return 10;
        }
        if (bzVar.bpZ()) {
            return 9;
        }
        if (bzVar.btq()) {
            return 8;
        }
        if (bzVar.btp()) {
            return 7;
        }
        if (bzVar.isShareThread) {
            return 6;
        }
        if (bzVar.threadType == 0) {
            return 1;
        }
        if (bzVar.threadType == 40) {
            return 2;
        }
        if (bzVar.threadType == 49) {
            return 3;
        }
        if (bzVar.threadType == 54) {
            return 4;
        }
        return 5;
    }

    private String getShareImageUrl(bz bzVar) {
        String str;
        if (bzVar == null) {
            return null;
        }
        if (bzVar.brK() != null && !TextUtils.isEmpty(bzVar.brK().cover)) {
            return bzVar.brK().cover;
        }
        if (bzVar.brA() == null) {
            return null;
        }
        ArrayList<MediaData> brA = bzVar.brA();
        int size = brA.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                str = null;
                break;
            }
            MediaData mediaData = brA.get(i);
            if (mediaData != null && (mediaData.getType() == 3 || mediaData.getType() == 5)) {
                if (!StringUtils.isNull(mediaData.getThumbnails_url())) {
                    str = mediaData.getThumbnails_url();
                    break;
                } else if (!StringUtils.isNull(mediaData.getPicUrl())) {
                    str = mediaData.getPicUrl();
                    break;
                }
            }
            i++;
        }
        if (str == null && bzVar.brI() != null && !TextUtils.isEmpty(bzVar.brI().thumbnail_url)) {
            return bzVar.brI().thumbnail_url;
        }
        return str;
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
    }
}
