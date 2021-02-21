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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.au;
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
                JSONObject jSONObject = new JSONObject((Map) methodCall.argument("item"));
                cb cbVar = new cb();
                cbVar.parserJson(jSONObject);
                showShareDialog(cbVar);
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
            shareItem.fuP = true;
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.fuY);
            bundle.putInt("obj_type", shareItem.fvc);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.eUk);
            shareItem.ae(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(TbadkCoreApplication.getInst().getCurrentActivity(), shareItem, true);
            if (z) {
                f.ctG().b(shareDialogConfig);
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
    private void showShareDialog(cb cbVar) {
        String tid;
        String str;
        boolean z;
        Uri parse;
        String str2;
        String format;
        String str3;
        if (cbVar != null) {
            String valueOf = String.valueOf(cbVar.getFid());
            String bnU = cbVar.bnU();
            if (cbVar.eTn != null) {
                valueOf = cbVar.eTn.id;
                bnU = cbVar.eTn.ori_fname;
            }
            String title = cbVar.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = cbVar.getAbstract();
            }
            if (cbVar.bmz()) {
                tid = cbVar.getBaijiahaoData().oriUgcTid;
                str = "?share=9105&fr=dshare&dtype=" + cbVar.getBaijiahaoData().oriUgcType + "&dvid=" + cbVar.getBaijiahaoData().oriUgcVid + "&nid=" + cbVar.getBaijiahaoData().oriUgcNid;
            } else {
                tid = cbVar.getTid();
                str = "?share=9105&fr=share";
            }
            String str4 = "http://tieba.baidu.com/p/" + tid + str;
            if (cbVar.boj() != null && cbVar.boj().user_info != null) {
                try {
                    if (TbConfig.HTTPS_LIVE_SHARE_PREFIX.contains("?")) {
                        str3 = "https://tieba.baidu.com/ala/share&uname=" + URLEncoder.encode(cbVar.boj().user_info.user_name, "utf-8");
                    } else {
                        str3 = "https://tieba.baidu.com/ala/share?uname=" + URLEncoder.encode(cbVar.boj().user_info.user_name, "utf-8");
                    }
                    z = false;
                    str4 = str3;
                } catch (Exception e) {
                    BdLog.e(e);
                }
                String shareImageUrl = getShareImageUrl(cbVar);
                parse = shareImageUrl != null ? null : Uri.parse(shareImageUrl);
                str2 = cbVar.getAbstract();
                String string = TbadkApplication.getInst().getResources().getString(R.string.share_content_tpl);
                String string2 = TbadkApplication.getInst().getResources().getString(R.string.default_share_content_tpl);
                if (cbVar.bmz() || cbVar.bnQ() == null) {
                    format = MessageFormat.format(string, title, str2);
                } else {
                    format = (TextUtils.isEmpty(cbVar.getTitle()) || TextUtils.isEmpty(str2)) ? MessageFormat.format(string2, cbVar.bnQ().getName_show(), TbadkApplication.getInst().getResources().getString(R.string.default_share_content_tpl_suffix)) : str2;
                }
                String cutString = au.cutString(title, 100);
                String cutString2 = au.cutString(format, 100);
                ShareItem shareItem = new ShareItem();
                shareItem.title = cutString;
                shareItem.content = cutString2;
                int stateThreadType = getStateThreadType(cbVar);
                if (!cbVar.bmz()) {
                    shareItem.readCount = -1L;
                    shareItem.fuV = cutString2;
                } else {
                    if (stateThreadType == 2 && cbVar.boh() != null) {
                        shareItem.readCount = cbVar.boh().play_count.intValue();
                    } else if (stateThreadType == 1) {
                        shareItem.readCount = cbVar.bnI();
                    }
                    shareItem.fuV = str2;
                }
                shareItem.linkUrl = str4;
                shareItem.extData = tid;
                shareItem.fid = valueOf;
                shareItem.fName = bnU;
                shareItem.tid = tid;
                shareItem.fuK = true;
                shareItem.eUk = 6;
                shareItem.fuX = 8;
                shareItem.fvc = stateThreadType;
                shareItem.fuY = 3;
                shareItem.fuZ = getShareObjParam2(cbVar);
                if (parse != null) {
                    shareItem.imageUri = parse;
                }
                if (cbVar.bmz()) {
                    z = false;
                }
                shareItem.canShareBySmartApp = z;
                if (z) {
                    shareItem.fvm = cbVar.getShareImageUrl();
                }
                shareItem.fvf = OriginalThreadInfo.ShareInfo.generateShareInfo(cbVar);
                shareItem.fvg = ShareItem.ForwardInfo.generateForwardInfo(cbVar);
                TbadkCoreApplication.getInst().setShareItem(shareItem);
                Bundle bundle = new Bundle();
                bundle.putInt("obj_param1", shareItem.fuY);
                bundle.putInt("obj_type", shareItem.fvc);
                bundle.putString("fid", shareItem.fid);
                bundle.putString("tid", shareItem.tid);
                bundle.putInt("obj_source", shareItem.eUk);
                shareItem.ae(bundle);
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(TbadkCoreApplication.getInst().getCurrentActivity(), shareItem, true);
                boolean z2 = false;
                shareDialogConfig.setIsAlaLive((cbVar.getThreadType() != 49 || cbVar.getThreadType() == 60) ? true : true);
                shareDialogConfig.setFrom(ShareDialogConfig.From.PersonPolymeric);
                f.ctG().b(shareDialogConfig);
            }
            z = true;
            String shareImageUrl2 = getShareImageUrl(cbVar);
            if (shareImageUrl2 != null) {
            }
            str2 = cbVar.getAbstract();
            String string3 = TbadkApplication.getInst().getResources().getString(R.string.share_content_tpl);
            String string22 = TbadkApplication.getInst().getResources().getString(R.string.default_share_content_tpl);
            if (cbVar.bmz()) {
            }
            format = MessageFormat.format(string3, title, str2);
            String cutString3 = au.cutString(title, 100);
            String cutString22 = au.cutString(format, 100);
            ShareItem shareItem2 = new ShareItem();
            shareItem2.title = cutString3;
            shareItem2.content = cutString22;
            int stateThreadType2 = getStateThreadType(cbVar);
            if (!cbVar.bmz()) {
            }
            shareItem2.linkUrl = str4;
            shareItem2.extData = tid;
            shareItem2.fid = valueOf;
            shareItem2.fName = bnU;
            shareItem2.tid = tid;
            shareItem2.fuK = true;
            shareItem2.eUk = 6;
            shareItem2.fuX = 8;
            shareItem2.fvc = stateThreadType2;
            shareItem2.fuY = 3;
            shareItem2.fuZ = getShareObjParam2(cbVar);
            if (parse != null) {
            }
            if (cbVar.bmz()) {
            }
            shareItem2.canShareBySmartApp = z;
            if (z) {
            }
            shareItem2.fvf = OriginalThreadInfo.ShareInfo.generateShareInfo(cbVar);
            shareItem2.fvg = ShareItem.ForwardInfo.generateForwardInfo(cbVar);
            TbadkCoreApplication.getInst().setShareItem(shareItem2);
            Bundle bundle2 = new Bundle();
            bundle2.putInt("obj_param1", shareItem2.fuY);
            bundle2.putInt("obj_type", shareItem2.fvc);
            bundle2.putString("fid", shareItem2.fid);
            bundle2.putString("tid", shareItem2.tid);
            bundle2.putInt("obj_source", shareItem2.eUk);
            shareItem2.ae(bundle2);
            ShareDialogConfig shareDialogConfig2 = new ShareDialogConfig(TbadkCoreApplication.getInst().getCurrentActivity(), shareItem2, true);
            boolean z22 = false;
            shareDialogConfig2.setIsAlaLive((cbVar.getThreadType() != 49 || cbVar.getThreadType() == 60) ? true : true);
            shareDialogConfig2.setFrom(ShareDialogConfig.From.PersonPolymeric);
            f.ctG().b(shareDialogConfig2);
        }
    }

    private int getStateThreadType(cb cbVar) {
        if (cbVar != null) {
            if (cbVar.bnS()) {
                return 4;
            }
            if (cbVar.bnN() == 1) {
                return 3;
            }
            if (cbVar.bmx()) {
                return 5;
            }
            if (cbVar.bmy()) {
                return 6;
            }
            if (cbVar.bpN()) {
                return 7;
            }
            if (cbVar.bpO()) {
                return 8;
            }
            if (!cbVar.isShareThread || cbVar.eTc == null) {
                return cbVar.bpk() ? 2 : 1;
            }
            return 9;
        }
        return 0;
    }

    private int getShareObjParam2(cb cbVar) {
        if (cbVar == null) {
            return 0;
        }
        if (cbVar.bmx()) {
            return 10;
        }
        if (cbVar.bmy()) {
            return 9;
        }
        if (cbVar.bpO()) {
            return 8;
        }
        if (cbVar.bpN()) {
            return 7;
        }
        if (cbVar.isShareThread) {
            return 6;
        }
        if (cbVar.threadType == 0) {
            return 1;
        }
        if (cbVar.threadType == 40) {
            return 2;
        }
        if (cbVar.threadType == 49) {
            return 3;
        }
        if (cbVar.threadType == 54) {
            return 4;
        }
        return 5;
    }

    private String getShareImageUrl(cb cbVar) {
        String str;
        if (cbVar == null) {
            return null;
        }
        if (cbVar.boj() != null && !TextUtils.isEmpty(cbVar.boj().cover)) {
            return cbVar.boj().cover;
        }
        if (cbVar.bnZ() == null) {
            return null;
        }
        ArrayList<MediaData> bnZ = cbVar.bnZ();
        int size = bnZ.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                str = null;
                break;
            }
            MediaData mediaData = bnZ.get(i);
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
        if (str == null && cbVar.boh() != null && !TextUtils.isEmpty(cbVar.boh().thumbnail_url)) {
            return cbVar.boh().thumbnail_url;
        }
        return str;
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
    }
}
