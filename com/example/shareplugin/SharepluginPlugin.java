package com.example.shareplugin;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
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
import com.baidu.tbadk.core.data.bw;
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
/* loaded from: classes14.dex */
public class SharepluginPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {
    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        new MethodChannel(flutterPluginBinding.getFlutterEngine().getDartExecutor(), "shareplugin").setMethodCallHandler(new SharepluginPlugin());
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
        if (methodCall.method.equals("getPlatformVersion")) {
            result.success("Android " + Build.VERSION.RELEASE);
        } else if (methodCall.method.equals("shareThread")) {
            try {
                JSONObject jSONObject = new JSONObject((Map) methodCall.argument(MapController.ITEM_LAYER_TAG));
                bw bwVar = new bw();
                bwVar.parserJson(jSONObject);
                showShareDialog(bwVar);
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
            shareItem.eEk = true;
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.eEt);
            bundle.putInt("obj_type", shareItem.eEx);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.eeB);
            shareItem.ae(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(TbadkCoreApplication.getInst().getCurrentActivity(), shareItem, true);
            if (z) {
                f.cdb().b(shareDialogConfig);
                return;
            }
            shareDialogConfig.isCopyLink = true;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    private void showShareDialog(bw bwVar) {
        String tid;
        String str;
        String format;
        String str2;
        if (bwVar != null) {
            String valueOf = String.valueOf(bwVar.getFid());
            String beI = bwVar.beI();
            if (bwVar.edP != null) {
                valueOf = bwVar.edP.id;
                beI = bwVar.edP.ori_fname;
            }
            String title = bwVar.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = bwVar.getAbstract();
            }
            if (bwVar.bdo()) {
                tid = bwVar.getBaijiahaoData().oriUgcTid;
                str = "?share=9105&fr=dshare&dtype=" + bwVar.getBaijiahaoData().oriUgcType + "&dvid=" + bwVar.getBaijiahaoData().oriUgcVid + "&nid=" + bwVar.getBaijiahaoData().oriUgcNid;
            } else {
                tid = bwVar.getTid();
                str = "?share=9105&fr=share";
            }
            String str3 = "http://tieba.baidu.com/p/" + tid + str;
            boolean z = true;
            if (bwVar.beY() != null && bwVar.beY().user_info != null) {
                try {
                    if (TbConfig.HTTPS_LIVE_SHARE_PREFIX.contains("?")) {
                        str2 = "https://tieba.baidu.com/ala/share&uname=" + URLEncoder.encode(bwVar.beY().user_info.user_name, "utf-8");
                    } else {
                        str2 = "https://tieba.baidu.com/ala/share?uname=" + URLEncoder.encode(bwVar.beY().user_info.user_name, "utf-8");
                    }
                    str3 = str2;
                    z = false;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            String shareImageUrl = getShareImageUrl(bwVar);
            Uri parse = shareImageUrl == null ? null : Uri.parse(shareImageUrl);
            String str4 = bwVar.getAbstract();
            String string = TbadkApplication.getInst().getResources().getString(R.string.share_content_tpl);
            String string2 = TbadkApplication.getInst().getResources().getString(R.string.default_share_content_tpl);
            if (!bwVar.bdo() || bwVar.beE() == null) {
                format = MessageFormat.format(string, title, str4);
            } else {
                format = (TextUtils.isEmpty(bwVar.getTitle()) || TextUtils.isEmpty(str4)) ? MessageFormat.format(string2, bwVar.beE().getName_show(), TbadkApplication.getInst().getResources().getString(R.string.default_share_content_tpl_suffix)) : str4;
            }
            String cutString = at.cutString(title, 100);
            String cutString2 = at.cutString(format, 100);
            ShareItem shareItem = new ShareItem();
            shareItem.title = cutString;
            shareItem.content = cutString2;
            int stateThreadType = getStateThreadType(bwVar);
            if (bwVar.bdo()) {
                shareItem.readCount = -1L;
                shareItem.eEq = cutString2;
            } else {
                if (stateThreadType == 2 && bwVar.beW() != null) {
                    shareItem.readCount = bwVar.beW().play_count.intValue();
                } else if (stateThreadType == 1) {
                    shareItem.readCount = bwVar.bew();
                }
                shareItem.eEq = str4;
            }
            shareItem.linkUrl = str3;
            shareItem.extData = tid;
            shareItem.fid = valueOf;
            shareItem.fName = beI;
            shareItem.tid = tid;
            shareItem.eEf = true;
            shareItem.eeB = 6;
            shareItem.eEs = 8;
            shareItem.eEx = stateThreadType;
            shareItem.eEt = 3;
            shareItem.eEu = getShareObjParam2(bwVar);
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            if (bwVar.bdo()) {
                z = false;
            }
            shareItem.canShareBySmartApp = z;
            if (z) {
                shareItem.eEH = bwVar.getShareImageUrl();
            }
            shareItem.eEA = OriginalThreadInfo.ShareInfo.generateShareInfo(bwVar);
            shareItem.eEB = ShareItem.ForwardInfo.generateForwardInfo(bwVar);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.eEt);
            bundle.putInt("obj_type", shareItem.eEx);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.eeB);
            shareItem.ae(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(TbadkCoreApplication.getInst().getCurrentActivity(), shareItem, true);
            boolean z2 = false;
            shareDialogConfig.setIsAlaLive((bwVar.getThreadType() == 49 || bwVar.getThreadType() == 60) ? true : true);
            shareDialogConfig.setFrom(ShareDialogConfig.From.PersonPolymeric);
            f.cdb().b(shareDialogConfig);
        }
    }

    private int getStateThreadType(bw bwVar) {
        if (bwVar != null) {
            if (bwVar.beG()) {
                return 4;
            }
            if (bwVar.beB() == 1) {
                return 3;
            }
            if (bwVar.bdm()) {
                return 5;
            }
            if (bwVar.bdn()) {
                return 6;
            }
            if (bwVar.bgz()) {
                return 7;
            }
            if (bwVar.bgA()) {
                return 8;
            }
            if (!bwVar.isShareThread || bwVar.edE == null) {
                return bwVar.bfW() ? 2 : 1;
            }
            return 9;
        }
        return 0;
    }

    private int getShareObjParam2(bw bwVar) {
        if (bwVar == null) {
            return 0;
        }
        if (bwVar.bdm()) {
            return 10;
        }
        if (bwVar.bdn()) {
            return 9;
        }
        if (bwVar.bgA()) {
            return 8;
        }
        if (bwVar.bgz()) {
            return 7;
        }
        if (bwVar.isShareThread) {
            return 6;
        }
        if (bwVar.threadType == 0) {
            return 1;
        }
        if (bwVar.threadType == 40) {
            return 2;
        }
        if (bwVar.threadType == 49) {
            return 3;
        }
        if (bwVar.threadType == 54) {
            return 4;
        }
        return 5;
    }

    private String getShareImageUrl(bw bwVar) {
        String str;
        if (bwVar == null) {
            return null;
        }
        if (bwVar.beY() != null && !TextUtils.isEmpty(bwVar.beY().cover)) {
            return bwVar.beY().cover;
        }
        if (bwVar.beN() == null) {
            return null;
        }
        ArrayList<MediaData> beN = bwVar.beN();
        int size = beN.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                str = null;
                break;
            }
            MediaData mediaData = beN.get(i);
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
        if (str == null && bwVar.beW() != null && !TextUtils.isEmpty(bwVar.beW().thumbnail_url)) {
            return bwVar.beW().thumbnail_url;
        }
        return str;
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
    }
}
