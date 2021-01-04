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
/* loaded from: classes15.dex */
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
                f.cwe().b(shareDialogConfig);
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
            String bru = bzVar.bru();
            if (bzVar.eVM != null) {
                valueOf = bzVar.eVM.id;
                bru = bzVar.eVM.ori_fname;
            }
            String title = bzVar.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = bzVar.getAbstract();
            }
            if (bzVar.bpZ()) {
                tid = bzVar.getBaijiahaoData().oriUgcTid;
                str = "?share=9105&fr=dshare&dtype=" + bzVar.getBaijiahaoData().oriUgcType + "&dvid=" + bzVar.getBaijiahaoData().oriUgcVid + "&nid=" + bzVar.getBaijiahaoData().oriUgcNid;
            } else {
                tid = bzVar.getTid();
                str = "?share=9105&fr=share";
            }
            String str4 = "http://tieba.baidu.com/p/" + tid + str;
            if (bzVar.brJ() != null && bzVar.brJ().user_info != null) {
                try {
                    if (TbConfig.HTTPS_LIVE_SHARE_PREFIX.contains("?")) {
                        str3 = "https://tieba.baidu.com/ala/share&uname=" + URLEncoder.encode(bzVar.brJ().user_info.user_name, "utf-8");
                    } else {
                        str3 = "https://tieba.baidu.com/ala/share?uname=" + URLEncoder.encode(bzVar.brJ().user_info.user_name, "utf-8");
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
                if (bzVar.bpZ() || bzVar.brq() == null) {
                    format = MessageFormat.format(string, title, str2);
                } else {
                    format = (TextUtils.isEmpty(bzVar.getTitle()) || TextUtils.isEmpty(str2)) ? MessageFormat.format(string2, bzVar.brq().getName_show(), TbadkApplication.getInst().getResources().getString(R.string.default_share_content_tpl_suffix)) : str2;
                }
                String cutString = at.cutString(title, 100);
                String cutString2 = at.cutString(format, 100);
                ShareItem shareItem = new ShareItem();
                shareItem.title = cutString;
                shareItem.content = cutString2;
                int stateThreadType = getStateThreadType(bzVar);
                if (!bzVar.bpZ()) {
                    shareItem.readCount = -1L;
                    shareItem.fxm = cutString2;
                } else {
                    if (stateThreadType == 2 && bzVar.brH() != null) {
                        shareItem.readCount = bzVar.brH().play_count.intValue();
                    } else if (stateThreadType == 1) {
                        shareItem.readCount = bzVar.bri();
                    }
                    shareItem.fxm = str2;
                }
                shareItem.linkUrl = str4;
                shareItem.extData = tid;
                shareItem.fid = valueOf;
                shareItem.fName = bru;
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
                if (bzVar.bpZ()) {
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
                f.cwe().b(shareDialogConfig);
            }
            z = true;
            String shareImageUrl2 = getShareImageUrl(bzVar);
            if (shareImageUrl2 != null) {
            }
            str2 = bzVar.getAbstract();
            String string3 = TbadkApplication.getInst().getResources().getString(R.string.share_content_tpl);
            String string22 = TbadkApplication.getInst().getResources().getString(R.string.default_share_content_tpl);
            if (bzVar.bpZ()) {
            }
            format = MessageFormat.format(string3, title, str2);
            String cutString3 = at.cutString(title, 100);
            String cutString22 = at.cutString(format, 100);
            ShareItem shareItem2 = new ShareItem();
            shareItem2.title = cutString3;
            shareItem2.content = cutString22;
            int stateThreadType2 = getStateThreadType(bzVar);
            if (!bzVar.bpZ()) {
            }
            shareItem2.linkUrl = str4;
            shareItem2.extData = tid;
            shareItem2.fid = valueOf;
            shareItem2.fName = bru;
            shareItem2.tid = tid;
            shareItem2.fxb = true;
            shareItem2.eWH = 6;
            shareItem2.fxo = 8;
            shareItem2.fxt = stateThreadType2;
            shareItem2.fxp = 3;
            shareItem2.fxq = getShareObjParam2(bzVar);
            if (parse != null) {
            }
            if (bzVar.bpZ()) {
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
            f.cwe().b(shareDialogConfig2);
        }
    }

    private int getStateThreadType(bz bzVar) {
        if (bzVar != null) {
            if (bzVar.brs()) {
                return 4;
            }
            if (bzVar.brn() == 1) {
                return 3;
            }
            if (bzVar.bpX()) {
                return 5;
            }
            if (bzVar.bpY()) {
                return 6;
            }
            if (bzVar.bto()) {
                return 7;
            }
            if (bzVar.btp()) {
                return 8;
            }
            if (!bzVar.isShareThread || bzVar.eVB == null) {
                return bzVar.bsL() ? 2 : 1;
            }
            return 9;
        }
        return 0;
    }

    private int getShareObjParam2(bz bzVar) {
        if (bzVar == null) {
            return 0;
        }
        if (bzVar.bpX()) {
            return 10;
        }
        if (bzVar.bpY()) {
            return 9;
        }
        if (bzVar.btp()) {
            return 8;
        }
        if (bzVar.bto()) {
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
        if (bzVar.brJ() != null && !TextUtils.isEmpty(bzVar.brJ().cover)) {
            return bzVar.brJ().cover;
        }
        if (bzVar.brz() == null) {
            return null;
        }
        ArrayList<MediaData> brz = bzVar.brz();
        int size = brz.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                str = null;
                break;
            }
            MediaData mediaData = brz.get(i);
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
        if (str == null && bzVar.brH() != null && !TextUtils.isEmpty(bzVar.brH().thumbnail_url)) {
            return bzVar.brH().thumbnail_url;
        }
        return str;
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
    }
}
