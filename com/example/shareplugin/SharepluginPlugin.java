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
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.d.f;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes12.dex */
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
                by byVar = new by();
                byVar.parserJson(jSONObject);
                showShareDialog(byVar);
                result.success("");
            } catch (Exception e) {
                BdLog.e(e);
            }
        } else if (methodCall.method.equals("shareGameItemDetails")) {
            try {
                boolean equals = "1".equals(methodCall.argument("can_repost"));
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("url", (String) methodCall.argument("url"));
                hashMap.put("itemId", (String) methodCall.argument("itemId"));
                hashMap.put("itemName", (String) methodCall.argument("itemName"));
                hashMap.put(AlaStaticKeys.ALA_STATIC_VALUE_ICON, (String) methodCall.argument(AlaStaticKeys.ALA_STATIC_VALUE_ICON));
                hashMap.put("content", (String) methodCall.argument("content"));
                showShareDetailsDialog(hashMap, equals);
                result.success("");
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        } else {
            result.notImplemented();
        }
    }

    private void showShareDetailsDialog(HashMap<String, String> hashMap, boolean z) {
        if (hashMap != null) {
            ShareItem shareItem = new ShareItem();
            shareItem.linkUrl = hashMap.get("url");
            shareItem.extData = hashMap.get("itemId");
            shareItem.title = hashMap.get("itemName");
            shareItem.fnw = true;
            shareItem.imageUrl = hashMap.get(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
            shareItem.imageUri = Uri.parse(hashMap.get(AlaStaticKeys.ALA_STATIC_VALUE_ICON));
            shareItem.content = hashMap.get("content");
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.fnF);
            bundle.putInt("obj_type", shareItem.fnJ);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.eMJ);
            shareItem.ae(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(TbadkCoreApplication.getInst().getCurrentActivity(), shareItem, true);
            if (z) {
                f.ctl().b(shareDialogConfig);
                return;
            }
            shareDialogConfig.isCopyLink = true;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    private void showShareDialog(by byVar) {
        String tid;
        String str;
        String format;
        String str2;
        if (byVar != null) {
            String valueOf = String.valueOf(byVar.getFid());
            String boT = byVar.boT();
            if (byVar.eLS != null) {
                valueOf = byVar.eLS.id;
                boT = byVar.eLS.ori_fname;
            }
            String title = byVar.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = byVar.getAbstract();
            }
            if (byVar.bnz()) {
                tid = byVar.getBaijiahaoData().oriUgcTid;
                str = "?share=9105&fr=dshare&dtype=" + byVar.getBaijiahaoData().oriUgcType + "&dvid=" + byVar.getBaijiahaoData().oriUgcVid + "&nid=" + byVar.getBaijiahaoData().oriUgcNid;
            } else {
                tid = byVar.getTid();
                str = "?share=9105&fr=share";
            }
            String str3 = "http://tieba.baidu.com/p/" + tid + str;
            boolean z = true;
            if (byVar.bpj() != null && byVar.bpj().user_info != null) {
                try {
                    if (TbConfig.HTTPS_LIVE_SHARE_PREFIX.contains("?")) {
                        str2 = "https://tieba.baidu.com/ala/share&uname=" + URLEncoder.encode(byVar.bpj().user_info.user_name, "utf-8");
                    } else {
                        str2 = "https://tieba.baidu.com/ala/share?uname=" + URLEncoder.encode(byVar.bpj().user_info.user_name, "utf-8");
                    }
                    str3 = str2;
                    z = false;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            String shareImageUrl = getShareImageUrl(byVar);
            Uri parse = shareImageUrl == null ? null : Uri.parse(shareImageUrl);
            String str4 = byVar.getAbstract();
            String string = TbadkApplication.getInst().getResources().getString(R.string.share_content_tpl);
            String string2 = TbadkApplication.getInst().getResources().getString(R.string.default_share_content_tpl);
            if (!byVar.bnz() || byVar.boP() == null) {
                format = MessageFormat.format(string, title, str4);
            } else {
                format = (TextUtils.isEmpty(byVar.getTitle()) || TextUtils.isEmpty(str4)) ? MessageFormat.format(string2, byVar.boP().getName_show(), TbadkApplication.getInst().getResources().getString(R.string.default_share_content_tpl_suffix)) : str4;
            }
            String cutString = au.cutString(title, 100);
            String cutString2 = au.cutString(format, 100);
            ShareItem shareItem = new ShareItem();
            shareItem.title = cutString;
            shareItem.content = cutString2;
            int stateThreadType = getStateThreadType(byVar);
            if (byVar.bnz()) {
                shareItem.readCount = -1L;
                shareItem.fnC = cutString2;
            } else {
                if (stateThreadType == 2 && byVar.bph() != null) {
                    shareItem.readCount = byVar.bph().play_count.intValue();
                } else if (stateThreadType == 1) {
                    shareItem.readCount = byVar.boH();
                }
                shareItem.fnC = str4;
            }
            shareItem.linkUrl = str3;
            shareItem.extData = tid;
            shareItem.fid = valueOf;
            shareItem.fName = boT;
            shareItem.tid = tid;
            shareItem.fnr = true;
            shareItem.eMJ = 6;
            shareItem.fnE = 8;
            shareItem.fnJ = stateThreadType;
            shareItem.fnF = 3;
            shareItem.fnG = getShareObjParam2(byVar);
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            if (byVar.bnz()) {
                z = false;
            }
            shareItem.canShareBySmartApp = z;
            if (z) {
                shareItem.fnT = byVar.getShareImageUrl();
            }
            shareItem.fnM = OriginalThreadInfo.ShareInfo.generateShareInfo(byVar);
            shareItem.fnN = ShareItem.ForwardInfo.generateForwardInfo(byVar);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.fnF);
            bundle.putInt("obj_type", shareItem.fnJ);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.eMJ);
            shareItem.ae(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(TbadkCoreApplication.getInst().getCurrentActivity(), shareItem, true);
            boolean z2 = false;
            shareDialogConfig.setIsAlaLive((byVar.getThreadType() == 49 || byVar.getThreadType() == 60) ? true : true);
            shareDialogConfig.setFrom(ShareDialogConfig.From.PersonPolymeric);
            f.ctl().b(shareDialogConfig);
        }
    }

    private int getStateThreadType(by byVar) {
        if (byVar != null) {
            if (byVar.boR()) {
                return 4;
            }
            if (byVar.boM() == 1) {
                return 3;
            }
            if (byVar.bnx()) {
                return 5;
            }
            if (byVar.bny()) {
                return 6;
            }
            if (byVar.bqM()) {
                return 7;
            }
            if (byVar.bqN()) {
                return 8;
            }
            if (!byVar.isShareThread || byVar.eLH == null) {
                return byVar.bqj() ? 2 : 1;
            }
            return 9;
        }
        return 0;
    }

    private int getShareObjParam2(by byVar) {
        if (byVar == null) {
            return 0;
        }
        if (byVar.bnx()) {
            return 10;
        }
        if (byVar.bny()) {
            return 9;
        }
        if (byVar.bqN()) {
            return 8;
        }
        if (byVar.bqM()) {
            return 7;
        }
        if (byVar.isShareThread) {
            return 6;
        }
        if (byVar.threadType == 0) {
            return 1;
        }
        if (byVar.threadType == 40) {
            return 2;
        }
        if (byVar.threadType == 49) {
            return 3;
        }
        if (byVar.threadType == 54) {
            return 4;
        }
        return 5;
    }

    private String getShareImageUrl(by byVar) {
        String str;
        if (byVar == null) {
            return null;
        }
        if (byVar.bpj() != null && !TextUtils.isEmpty(byVar.bpj().cover)) {
            return byVar.bpj().cover;
        }
        if (byVar.boY() == null) {
            return null;
        }
        ArrayList<MediaData> boY = byVar.boY();
        int size = boY.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                str = null;
                break;
            }
            MediaData mediaData = boY.get(i);
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
        if (str == null && byVar.bph() != null && !TextUtils.isEmpty(byVar.bph().thumbnail_url)) {
            return byVar.bph().thumbnail_url;
        }
        return str;
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
    }
}
