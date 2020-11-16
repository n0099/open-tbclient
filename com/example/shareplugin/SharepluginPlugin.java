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
import com.baidu.tbadk.core.data.bx;
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
/* loaded from: classes17.dex */
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
                bx bxVar = new bx();
                bxVar.parserJson(jSONObject);
                showShareDialog(bxVar);
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
            shareItem.ffW = true;
            shareItem.imageUrl = hashMap.get(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
            shareItem.imageUri = Uri.parse(hashMap.get(AlaStaticKeys.ALA_STATIC_VALUE_ICON));
            shareItem.content = hashMap.get("content");
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.fgf);
            bundle.putInt("obj_type", shareItem.fgj);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.eFG);
            shareItem.ae(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(TbadkCoreApplication.getInst().getCurrentActivity(), shareItem, true);
            if (z) {
                f.coW().b(shareDialogConfig);
                return;
            }
            shareDialogConfig.isCopyLink = true;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    private void showShareDialog(bx bxVar) {
        String tid;
        String str;
        String format;
        String str2;
        if (bxVar != null) {
            String valueOf = String.valueOf(bxVar.getFid());
            String blG = bxVar.blG();
            if (bxVar.eEQ != null) {
                valueOf = bxVar.eEQ.id;
                blG = bxVar.eEQ.ori_fname;
            }
            String title = bxVar.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = bxVar.getAbstract();
            }
            if (bxVar.bkm()) {
                tid = bxVar.getBaijiahaoData().oriUgcTid;
                str = "?share=9105&fr=dshare&dtype=" + bxVar.getBaijiahaoData().oriUgcType + "&dvid=" + bxVar.getBaijiahaoData().oriUgcVid + "&nid=" + bxVar.getBaijiahaoData().oriUgcNid;
            } else {
                tid = bxVar.getTid();
                str = "?share=9105&fr=share";
            }
            String str3 = "http://tieba.baidu.com/p/" + tid + str;
            boolean z = true;
            if (bxVar.blW() != null && bxVar.blW().user_info != null) {
                try {
                    if (TbConfig.HTTPS_LIVE_SHARE_PREFIX.contains("?")) {
                        str2 = "https://tieba.baidu.com/ala/share&uname=" + URLEncoder.encode(bxVar.blW().user_info.user_name, "utf-8");
                    } else {
                        str2 = "https://tieba.baidu.com/ala/share?uname=" + URLEncoder.encode(bxVar.blW().user_info.user_name, "utf-8");
                    }
                    str3 = str2;
                    z = false;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            String shareImageUrl = getShareImageUrl(bxVar);
            Uri parse = shareImageUrl == null ? null : Uri.parse(shareImageUrl);
            String str4 = bxVar.getAbstract();
            String string = TbadkApplication.getInst().getResources().getString(R.string.share_content_tpl);
            String string2 = TbadkApplication.getInst().getResources().getString(R.string.default_share_content_tpl);
            if (!bxVar.bkm() || bxVar.blC() == null) {
                format = MessageFormat.format(string, title, str4);
            } else {
                format = (TextUtils.isEmpty(bxVar.getTitle()) || TextUtils.isEmpty(str4)) ? MessageFormat.format(string2, bxVar.blC().getName_show(), TbadkApplication.getInst().getResources().getString(R.string.default_share_content_tpl_suffix)) : str4;
            }
            String cutString = au.cutString(title, 100);
            String cutString2 = au.cutString(format, 100);
            ShareItem shareItem = new ShareItem();
            shareItem.title = cutString;
            shareItem.content = cutString2;
            int stateThreadType = getStateThreadType(bxVar);
            if (bxVar.bkm()) {
                shareItem.readCount = -1L;
                shareItem.fgc = cutString2;
            } else {
                if (stateThreadType == 2 && bxVar.blU() != null) {
                    shareItem.readCount = bxVar.blU().play_count.intValue();
                } else if (stateThreadType == 1) {
                    shareItem.readCount = bxVar.blu();
                }
                shareItem.fgc = str4;
            }
            shareItem.linkUrl = str3;
            shareItem.extData = tid;
            shareItem.fid = valueOf;
            shareItem.fName = blG;
            shareItem.tid = tid;
            shareItem.ffR = true;
            shareItem.eFG = 6;
            shareItem.fge = 8;
            shareItem.fgj = stateThreadType;
            shareItem.fgf = 3;
            shareItem.fgg = getShareObjParam2(bxVar);
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            if (bxVar.bkm()) {
                z = false;
            }
            shareItem.canShareBySmartApp = z;
            if (z) {
                shareItem.fgt = bxVar.getShareImageUrl();
            }
            shareItem.fgm = OriginalThreadInfo.ShareInfo.generateShareInfo(bxVar);
            shareItem.fgn = ShareItem.ForwardInfo.generateForwardInfo(bxVar);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.fgf);
            bundle.putInt("obj_type", shareItem.fgj);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.eFG);
            shareItem.ae(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(TbadkCoreApplication.getInst().getCurrentActivity(), shareItem, true);
            boolean z2 = false;
            shareDialogConfig.setIsAlaLive((bxVar.getThreadType() == 49 || bxVar.getThreadType() == 60) ? true : true);
            shareDialogConfig.setFrom(ShareDialogConfig.From.PersonPolymeric);
            f.coW().b(shareDialogConfig);
        }
    }

    private int getStateThreadType(bx bxVar) {
        if (bxVar != null) {
            if (bxVar.blE()) {
                return 4;
            }
            if (bxVar.blz() == 1) {
                return 3;
            }
            if (bxVar.bkk()) {
                return 5;
            }
            if (bxVar.bkl()) {
                return 6;
            }
            if (bxVar.bnz()) {
                return 7;
            }
            if (bxVar.bnA()) {
                return 8;
            }
            if (!bxVar.isShareThread || bxVar.eEF == null) {
                return bxVar.bmW() ? 2 : 1;
            }
            return 9;
        }
        return 0;
    }

    private int getShareObjParam2(bx bxVar) {
        if (bxVar == null) {
            return 0;
        }
        if (bxVar.bkk()) {
            return 10;
        }
        if (bxVar.bkl()) {
            return 9;
        }
        if (bxVar.bnA()) {
            return 8;
        }
        if (bxVar.bnz()) {
            return 7;
        }
        if (bxVar.isShareThread) {
            return 6;
        }
        if (bxVar.threadType == 0) {
            return 1;
        }
        if (bxVar.threadType == 40) {
            return 2;
        }
        if (bxVar.threadType == 49) {
            return 3;
        }
        if (bxVar.threadType == 54) {
            return 4;
        }
        return 5;
    }

    private String getShareImageUrl(bx bxVar) {
        String str;
        if (bxVar == null) {
            return null;
        }
        if (bxVar.blW() != null && !TextUtils.isEmpty(bxVar.blW().cover)) {
            return bxVar.blW().cover;
        }
        if (bxVar.blL() == null) {
            return null;
        }
        ArrayList<MediaData> blL = bxVar.blL();
        int size = blL.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                str = null;
                break;
            }
            MediaData mediaData = blL.get(i);
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
        if (str == null && bxVar.blU() != null && !TextUtils.isEmpty(bxVar.blU().thumbnail_url)) {
            return bxVar.blU().thumbnail_url;
        }
        return str;
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
    }
}
