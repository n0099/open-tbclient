package d.b.i0.d1.f;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.core.util.PicManager;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.util.resourceLoader.IMImageSize;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.gif.GifInfo;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.view.ChatClipImageItemView;
import com.baidu.tieba.im.chat.view.ChatImageWithTailView;
import com.baidu.tieba.im.data.InviteMsgData;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.widget.ShareFromFrsView;
import com.baidu.tieba.im.widget.ShareFromGameCenter;
import com.baidu.tieba.im.widget.ShareFromPBView;
import com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView;
import com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView;
import com.baidu.wallet.paysdk.datamodel.ErrorContentResponse;
import d.b.b.e.p.l;
import d.b.h0.z0.o;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f53683a;

    static {
        o.e();
    }

    public static void a(Context context, GifView gifView, ChatMessage chatMessage, boolean z) {
        double d2 = context.getResources().getDisplayMetrics().density;
        int i = d2 > 1.5d ? 240 : 160;
        int i2 = d2 <= 1.5d ? 160 : 240;
        gifView.setVisibility(0);
        GifInfo gifInfo = chatMessage.getGifInfo();
        if (chatMessage.getGifInfo() != null) {
            int i3 = gifInfo.mGifWidth;
            if (i3 > 0) {
                i = i3;
            }
            gifInfo.mGifWidth = i;
            int i4 = gifInfo.mGifHeight;
            if (i4 > 0) {
                i2 = i4;
            }
            gifInfo.mGifHeight = i2;
            gifView.setLayoutParams(new FrameLayout.LayoutParams(gifInfo.mGifWidth, gifInfo.mGifHeight));
            gifView.w0(gifInfo);
            gifView.setVisibility(0);
            return;
        }
        gifView.setVisibility(8);
    }

    public static void b(Context context, View view, ShareFromPBView shareFromPBView, ShareFromFrsView shareFromFrsView, ShareFromGameCenter shareFromGameCenter, ChatMessage chatMessage, String str) {
        if (chatMessage.getContent() == null || chatMessage.getContent().length() == 0) {
            return;
        }
        d.b.i0.d1.y.a aVar = new d.b.i0.d1.y.a();
        int c2 = aVar.c(chatMessage.getContent(), str);
        if (1 == aVar.b()) {
            if (aVar.a() != null) {
                if (c2 == 0) {
                    shareFromPBView.setVisibility(0);
                    shareFromPBView.setData(aVar.a() instanceof ShareFromPBMsgData ? (ShareFromPBMsgData) aVar.a() : null);
                } else if (c2 == 1) {
                    shareFromGameCenter.setVisibility(0);
                    ShareFromGameCenterMsgData shareFromGameCenterMsgData = aVar.a() instanceof ShareFromGameCenterMsgData ? (ShareFromGameCenterMsgData) aVar.a() : null;
                    if (!TextUtils.isEmpty(str) && str.endsWith("MsgleftView")) {
                        shareFromGameCenter.setData(shareFromGameCenterMsgData, false);
                    } else if (TextUtils.isEmpty(str) || !str.endsWith("MsgrightView")) {
                    } else {
                        shareFromGameCenter.setData(shareFromGameCenterMsgData, true);
                    }
                }
            }
        } else if (4 == aVar.b()) {
            shareFromFrsView.setVisibility(0);
            shareFromFrsView.setData(aVar.a() instanceof ShareFromFrsMsgData ? (ShareFromFrsMsgData) aVar.a() : null);
        }
    }

    public static void c(TbPageContext<?> tbPageContext, Context context, View view, Invite2GroupView invite2GroupView, ChatMessage chatMessage, String str) {
        if (chatMessage.getContent() == null || chatMessage.getContent().length() == 0) {
            return;
        }
        invite2GroupView.setVisibility(0);
        try {
            JSONObject jSONObject = new JSONObject(chatMessage.getContent());
            if (jSONObject.getString("portrait") == null) {
                return;
            }
            InviteMsgData inviteMsgData = new InviteMsgData();
            inviteMsgData.setFromUid(jSONObject.getLong("fromUid"));
            inviteMsgData.setGroupId(jSONObject.getLong(TbEnum.SystemMessage.KEY_GROUP_ID));
            inviteMsgData.setNotice(jSONObject.getString(ErrorContentResponse.Operations.NOTICE));
            inviteMsgData.setPortrait(jSONObject.getString("portrait"));
            inviteMsgData.setText(jSONObject.getString("text"));
            inviteMsgData.setTitle(jSONObject.getString("title"));
            inviteMsgData.setToUid(jSONObject.getLong("toUid"));
            inviteMsgData.setGroupName(jSONObject.getString(TbEnum.SystemMessage.KEY_GROUP_NAME));
            inviteMsgData.setGroupOwnerId(jSONObject.getLong("groupOwnerId"));
            invite2GroupView.setData(tbPageContext, inviteMsgData);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00b7 A[Catch: Exception -> 0x01bc, TryCatch #2 {Exception -> 0x01bc, blocks: (B:7:0x0012, B:10:0x0039, B:12:0x0045, B:27:0x00a0, B:29:0x00a6, B:31:0x00ae, B:33:0x00b7, B:34:0x00c0, B:36:0x00c3, B:37:0x00cc, B:39:0x0114, B:41:0x0123, B:42:0x012a, B:44:0x0149, B:46:0x015d, B:48:0x0163, B:51:0x016a, B:53:0x0170, B:55:0x0178, B:56:0x0196, B:57:0x01b8, B:43:0x0132), top: B:69:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c3 A[Catch: Exception -> 0x01bc, TryCatch #2 {Exception -> 0x01bc, blocks: (B:7:0x0012, B:10:0x0039, B:12:0x0045, B:27:0x00a0, B:29:0x00a6, B:31:0x00ae, B:33:0x00b7, B:34:0x00c0, B:36:0x00c3, B:37:0x00cc, B:39:0x0114, B:41:0x0123, B:42:0x012a, B:44:0x0149, B:46:0x015d, B:48:0x0163, B:51:0x016a, B:53:0x0170, B:55:0x0178, B:56:0x0196, B:57:0x01b8, B:43:0x0132), top: B:69:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0114 A[Catch: Exception -> 0x01bc, TryCatch #2 {Exception -> 0x01bc, blocks: (B:7:0x0012, B:10:0x0039, B:12:0x0045, B:27:0x00a0, B:29:0x00a6, B:31:0x00ae, B:33:0x00b7, B:34:0x00c0, B:36:0x00c3, B:37:0x00cc, B:39:0x0114, B:41:0x0123, B:42:0x012a, B:44:0x0149, B:46:0x015d, B:48:0x0163, B:51:0x016a, B:53:0x0170, B:55:0x0178, B:56:0x0196, B:57:0x01b8, B:43:0x0132), top: B:69:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0132 A[Catch: Exception -> 0x01bc, TryCatch #2 {Exception -> 0x01bc, blocks: (B:7:0x0012, B:10:0x0039, B:12:0x0045, B:27:0x00a0, B:29:0x00a6, B:31:0x00ae, B:33:0x00b7, B:34:0x00c0, B:36:0x00c3, B:37:0x00cc, B:39:0x0114, B:41:0x0123, B:42:0x012a, B:44:0x0149, B:46:0x015d, B:48:0x0163, B:51:0x016a, B:53:0x0170, B:55:0x0178, B:56:0x0196, B:57:0x01b8, B:43:0x0132), top: B:69:0x0012 }] */
    @SuppressLint({"ResourceAsColor"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void d(Context context, View view, ChatImageWithTailView chatImageWithTailView, ChatMessage chatMessage, long j, String str) {
        d.b.b.j.d.a l;
        String optString;
        String[] split;
        if (chatMessage.getContent() == null || chatMessage.getContent().length() == 0) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONArray(chatMessage.getContent()).getJSONObject(0);
            String g2 = d.b.i0.d1.w.c.g(jSONObject, false);
            String optString2 = jSONObject.optString("shareSourceIcon");
            String optString3 = jSONObject.optString("shareSource");
            String optString4 = jSONObject.optString("shareSourceUrl");
            if (g2 == null) {
                return;
            }
            if (g2.startsWith("http")) {
                chatImageWithTailView.getImage().W(g2, 10, false);
            } else {
                try {
                    l = d.b.h0.a0.c.j().l(g2);
                    if (l == null) {
                        Bitmap reSizeBitmap = PicManager.getInstance().getReSizeBitmap(d.b.b.e.p.d.d().c(g2));
                        if (reSizeBitmap != null) {
                            d.b.b.j.d.a aVar = new d.b.b.j.d.a(reSizeBitmap, false);
                            try {
                                if (chatMessage.getWidth() < 1) {
                                    chatMessage.setWidth(aVar.r());
                                    chatMessage.setHeight(aVar.m());
                                }
                                d.b.h0.a0.c.j().d(g2, aVar);
                            } catch (Exception unused) {
                            }
                            l = aVar;
                        }
                    } else {
                        try {
                            if (chatMessage.getWidth() < 1) {
                                chatMessage.setWidth(l.r());
                                chatMessage.setHeight(l.m());
                            }
                        } catch (Exception unused2) {
                        }
                    }
                } catch (Exception unused3) {
                }
                if (chatMessage.getWidth() < 1 && (optString = jSONObject.optString("bsize")) != null) {
                    split = optString.split(",");
                    if (split.length > 0) {
                        chatMessage.setWidth(d.b.b.e.m.b.d(split[0], 0));
                    }
                    if (split.length > 1) {
                        chatMessage.setHeight(d.b.b.e.m.b.d(split[1], 0));
                    }
                }
                LocalViewSize.getInstance();
                LocalViewSize.ImageSize msgSPicShowSize = LocalViewSize.getInstance().getMsgSPicShowSize(LocalViewSize.getInstance().getMsgSPicMaxSize(), chatMessage.getHeight(), chatMessage.getWidth());
                IMImageSize imageSize = PicManager.getInstance().getImageSize(msgSPicShowSize.width, msgSPicShowSize.height, true);
                msgSPicShowSize.height = imageSize.height;
                msgSPicShowSize.width = imageSize.width;
                ViewGroup.LayoutParams layoutParams = chatImageWithTailView.getImage().getLayoutParams();
                layoutParams.height = msgSPicShowSize.height;
                layoutParams.width = msgSPicShowSize.width;
                chatImageWithTailView.getImage().setLayoutParams(layoutParams);
                if (l == null) {
                    chatImageWithTailView.getImage().S();
                    if (chatImageWithTailView.getImage() instanceof ChatClipImageItemView) {
                        chatImageWithTailView.getImage().h0();
                    }
                    l.h(chatImageWithTailView.getImage());
                } else {
                    chatImageWithTailView.getImage().setImageDrawable(null);
                    chatImageWithTailView.getImage().setDefaultResource(R.drawable.pic_image_h_not);
                    chatImageWithTailView.getImage().setTag(g2);
                }
                chatImageWithTailView.getImage().setDrawBorder(false);
                chatImageWithTailView.getImage().setAutoChangeStyle(false);
                if (!TextUtils.isEmpty(optString4) && !TextUtils.isEmpty(optString3) && !TextUtils.isEmpty(optString2)) {
                    if (!TextUtils.isEmpty(str) && str.endsWith("MsgleftView")) {
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                        layoutParams2.setMargins(l.g(context, R.dimen.ds14), 0, 0, 0);
                        layoutParams2.height = l.g(context, R.dimen.ds48);
                        chatImageWithTailView.getTail().setLayoutParams(layoutParams2);
                    }
                    chatImageWithTailView.getIcon().setDefaultResource(R.drawable.tb_launcher_icon);
                    chatImageWithTailView.getIcon().W(optString2, 10, false);
                    chatImageWithTailView.getFromSource().setText(optString3);
                    chatImageWithTailView.setVisibility(0);
                    chatImageWithTailView.getTail().setVisibility(0);
                    return;
                }
                chatImageWithTailView.setVisibility(0);
            }
            l = null;
            if (chatMessage.getWidth() < 1) {
                split = optString.split(",");
                if (split.length > 0) {
                }
                if (split.length > 1) {
                }
            }
            LocalViewSize.getInstance();
            LocalViewSize.ImageSize msgSPicShowSize2 = LocalViewSize.getInstance().getMsgSPicShowSize(LocalViewSize.getInstance().getMsgSPicMaxSize(), chatMessage.getHeight(), chatMessage.getWidth());
            IMImageSize imageSize2 = PicManager.getInstance().getImageSize(msgSPicShowSize2.width, msgSPicShowSize2.height, true);
            msgSPicShowSize2.height = imageSize2.height;
            msgSPicShowSize2.width = imageSize2.width;
            ViewGroup.LayoutParams layoutParams3 = chatImageWithTailView.getImage().getLayoutParams();
            layoutParams3.height = msgSPicShowSize2.height;
            layoutParams3.width = msgSPicShowSize2.width;
            chatImageWithTailView.getImage().setLayoutParams(layoutParams3);
            if (l == null) {
            }
            chatImageWithTailView.getImage().setDrawBorder(false);
            chatImageWithTailView.getImage().setAutoChangeStyle(false);
            if (!TextUtils.isEmpty(optString4)) {
                if (!TextUtils.isEmpty(str)) {
                    LinearLayout.LayoutParams layoutParams22 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams22.setMargins(l.g(context, R.dimen.ds14), 0, 0, 0);
                    layoutParams22.height = l.g(context, R.dimen.ds48);
                    chatImageWithTailView.getTail().setLayoutParams(layoutParams22);
                }
                chatImageWithTailView.getIcon().setDefaultResource(R.drawable.tb_launcher_icon);
                chatImageWithTailView.getIcon().W(optString2, 10, false);
                chatImageWithTailView.getFromSource().setText(optString3);
                chatImageWithTailView.setVisibility(0);
                chatImageWithTailView.getTail().setVisibility(0);
                return;
            }
            chatImageWithTailView.setVisibility(0);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void e(Context context, TbRichTextView tbRichTextView, ChatMessage chatMessage, String str, int i) {
        if (chatMessage == null) {
            return;
        }
        MsgCacheData cacheData = chatMessage.getCacheData();
        if (cacheData == null) {
            cacheData = d.b.i0.d1.w.c.h(chatMessage);
            chatMessage.setCacheData(cacheData);
        }
        if (cacheData.getRich_content() == null) {
            String content = chatMessage.getContent();
            if (content == null) {
                return;
            }
            TbRichText tbRichText = null;
            if (StringUtils.isJSONArray(content)) {
                try {
                    tbRichText = TbRichTextView.P(context, new JSONArray(chatMessage.getContent()), 7);
                } catch (Exception unused) {
                }
            }
            if (tbRichText == null) {
                tbRichText = new TbRichText(context, a.d(context, chatMessage.getContent(), i));
            }
            cacheData.setRich_content(tbRichText);
        }
        tbRichTextView.setVisibility(0);
        tbRichTextView.setText(cacheData.getRich_content());
    }

    public static void f(Context context, ChatVoiceView chatVoiceView, ChatMessage chatMessage, String str) {
        if (chatMessage.getContent() == null || chatMessage.getContent().length() <= 0) {
            return;
        }
        try {
            MsgCacheData cacheData = chatMessage.getCacheData();
            if (cacheData == null) {
                cacheData = new MsgCacheData();
                cacheData.setVoice_status(1);
                chatMessage.setCacheData(cacheData);
            } else if (cacheData.getVoice_status() == 0) {
                cacheData.setVoice_status(1);
            }
            VoiceMsgData n = d.b.i0.d1.w.c.n(chatMessage);
            if (n != null && n.getDuring_time() != 0.0f && cacheData.getVoice_model() == null) {
                cacheData.setVoice_model(new VoiceData$VoiceModel());
                cacheData.getVoice_model().voiceId = n.getVoice_md5();
                cacheData.getVoice_model().duration = Math.round(n.getDuring_time());
            }
            chatVoiceView.setTag(null);
            chatVoiceView.setData(chatMessage);
            chatVoiceView.setVisibility(0);
        } catch (Exception unused) {
        }
    }
}
