package com.repackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.VoiceData;
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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class g57 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755726968, "Lcom/repackage/g57;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755726968, "Lcom/repackage/g57;");
                return;
            }
        }
        jc5.e();
    }

    public static void a(Context context, GifView gifView, ChatMessage chatMessage, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{context, gifView, chatMessage, Boolean.valueOf(z)}) == null) {
            int i = (context.getResources().getDisplayMetrics().density > 1.5d ? 1 : (context.getResources().getDisplayMetrics().density == 1.5d ? 0 : -1));
            int i2 = i > 0 ? 240 : 160;
            int i3 = i <= 0 ? 160 : 240;
            gifView.setVisibility(0);
            GifInfo gifInfo = chatMessage.getGifInfo();
            if (chatMessage.getGifInfo() != null) {
                int i4 = gifInfo.mGifWidth;
                if (i4 > 0) {
                    i2 = i4;
                }
                gifInfo.mGifWidth = i2;
                int i5 = gifInfo.mGifHeight;
                if (i5 > 0) {
                    i3 = i5;
                }
                gifInfo.mGifHeight = i3;
                gifView.setLayoutParams(new FrameLayout.LayoutParams(gifInfo.mGifWidth, gifInfo.mGifHeight));
                gifView.g0(gifInfo);
                gifView.setVisibility(0);
                return;
            }
            gifView.setVisibility(8);
        }
    }

    public static void b(Context context, View view2, ShareFromPBView shareFromPBView, ShareFromFrsView shareFromFrsView, ShareFromGameCenter shareFromGameCenter, ChatMessage chatMessage, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{context, view2, shareFromPBView, shareFromFrsView, shareFromGameCenter, chatMessage, str}) == null) || chatMessage.getContent() == null || chatMessage.getContent().length() == 0) {
            return;
        }
        e97 e97Var = new e97();
        int c = e97Var.c(chatMessage.getContent(), str);
        if (1 == e97Var.b()) {
            if (e97Var.a() != null) {
                if (c == 0) {
                    shareFromPBView.setVisibility(0);
                    shareFromPBView.setData(e97Var.a() instanceof ShareFromPBMsgData ? (ShareFromPBMsgData) e97Var.a() : null);
                } else if (c == 1) {
                    shareFromGameCenter.setVisibility(0);
                    ShareFromGameCenterMsgData shareFromGameCenterMsgData = e97Var.a() instanceof ShareFromGameCenterMsgData ? (ShareFromGameCenterMsgData) e97Var.a() : null;
                    if (!TextUtils.isEmpty(str) && str.endsWith("MsgleftView")) {
                        shareFromGameCenter.setData(shareFromGameCenterMsgData, false);
                    } else if (TextUtils.isEmpty(str) || !str.endsWith("MsgrightView")) {
                    } else {
                        shareFromGameCenter.setData(shareFromGameCenterMsgData, true);
                    }
                }
            }
        } else if (4 == e97Var.b()) {
            shareFromFrsView.setVisibility(0);
            shareFromFrsView.setData(e97Var.a() instanceof ShareFromFrsMsgData ? (ShareFromFrsMsgData) e97Var.a() : null);
        }
    }

    public static void c(TbPageContext<?> tbPageContext, Context context, View view2, Invite2GroupView invite2GroupView, ChatMessage chatMessage, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{tbPageContext, context, view2, invite2GroupView, chatMessage, str}) == null) || chatMessage.getContent() == null || chatMessage.getContent().length() == 0) {
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
            inviteMsgData.setNotice(jSONObject.getString("notice"));
            inviteMsgData.setPortrait(jSONObject.getString("portrait"));
            inviteMsgData.setText(jSONObject.getString("text"));
            inviteMsgData.setTitle(jSONObject.getString("title"));
            inviteMsgData.setToUid(jSONObject.getLong("toUid"));
            inviteMsgData.setGroupName(jSONObject.getString(TbEnum.SystemMessage.KEY_GROUP_NAME));
            inviteMsgData.setGroupOwnerId(jSONObject.getLong("groupOwnerId"));
            invite2GroupView.setData(tbPageContext, inviteMsgData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00bb A[Catch: Exception -> 0x01c4, TryCatch #3 {Exception -> 0x01c4, blocks: (B:9:0x0016, B:12:0x003d, B:14:0x0049, B:29:0x00a4, B:31:0x00aa, B:33:0x00b2, B:35:0x00bb, B:36:0x00c4, B:38:0x00c7, B:39:0x00d0, B:41:0x0118, B:43:0x0127, B:44:0x012e, B:46:0x014e, B:48:0x0162, B:50:0x0168, B:53:0x016f, B:55:0x0175, B:57:0x017d, B:58:0x019d, B:59:0x01c0, B:45:0x0136), top: B:76:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c7 A[Catch: Exception -> 0x01c4, TryCatch #3 {Exception -> 0x01c4, blocks: (B:9:0x0016, B:12:0x003d, B:14:0x0049, B:29:0x00a4, B:31:0x00aa, B:33:0x00b2, B:35:0x00bb, B:36:0x00c4, B:38:0x00c7, B:39:0x00d0, B:41:0x0118, B:43:0x0127, B:44:0x012e, B:46:0x014e, B:48:0x0162, B:50:0x0168, B:53:0x016f, B:55:0x0175, B:57:0x017d, B:58:0x019d, B:59:0x01c0, B:45:0x0136), top: B:76:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0118 A[Catch: Exception -> 0x01c4, TryCatch #3 {Exception -> 0x01c4, blocks: (B:9:0x0016, B:12:0x003d, B:14:0x0049, B:29:0x00a4, B:31:0x00aa, B:33:0x00b2, B:35:0x00bb, B:36:0x00c4, B:38:0x00c7, B:39:0x00d0, B:41:0x0118, B:43:0x0127, B:44:0x012e, B:46:0x014e, B:48:0x0162, B:50:0x0168, B:53:0x016f, B:55:0x0175, B:57:0x017d, B:58:0x019d, B:59:0x01c0, B:45:0x0136), top: B:76:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0136 A[Catch: Exception -> 0x01c4, TryCatch #3 {Exception -> 0x01c4, blocks: (B:9:0x0016, B:12:0x003d, B:14:0x0049, B:29:0x00a4, B:31:0x00aa, B:33:0x00b2, B:35:0x00bb, B:36:0x00c4, B:38:0x00c7, B:39:0x00d0, B:41:0x0118, B:43:0x0127, B:44:0x012e, B:46:0x014e, B:48:0x0162, B:50:0x0168, B:53:0x016f, B:55:0x0175, B:57:0x017d, B:58:0x019d, B:59:0x01c0, B:45:0x0136), top: B:76:0x0016 }] */
    @SuppressLint({"ResourceAsColor"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void d(Context context, View view2, ChatImageWithTailView chatImageWithTailView, ChatMessage chatMessage, long j, String str) {
        fo m;
        String optString;
        String[] split;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{context, view2, chatImageWithTailView, chatMessage, Long.valueOf(j), str}) == null) || chatMessage.getContent() == null || chatMessage.getContent().length() == 0) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONArray(chatMessage.getContent()).getJSONObject(0);
            String g = a97.g(jSONObject, false);
            String optString2 = jSONObject.optString("shareSourceIcon");
            String optString3 = jSONObject.optString("shareSource");
            String optString4 = jSONObject.optString("shareSourceUrl");
            if (g == null) {
                return;
            }
            if (g.startsWith("http")) {
                chatImageWithTailView.getImage().K(g, 10, false);
            } else {
                try {
                    m = h35.k().m(g);
                    if (m == null) {
                        Bitmap reSizeBitmap = PicManager.getInstance().getReSizeBitmap(gi.d().c(g));
                        if (reSizeBitmap != null) {
                            fo foVar = new fo(reSizeBitmap, false);
                            try {
                                if (chatMessage.getWidth() < 1) {
                                    chatMessage.setWidth(foVar.r());
                                    chatMessage.setHeight(foVar.m());
                                }
                                h35.k().d(g, foVar);
                            } catch (Exception unused) {
                            }
                            m = foVar;
                        }
                    } else {
                        try {
                            if (chatMessage.getWidth() < 1) {
                                chatMessage.setWidth(m.r());
                                chatMessage.setHeight(m.m());
                            }
                        } catch (Exception unused2) {
                        }
                    }
                } catch (Exception unused3) {
                }
                if (chatMessage.getWidth() < 1 && (optString = jSONObject.optString("bsize")) != null) {
                    split = optString.split(",");
                    if (split.length > 0) {
                        chatMessage.setWidth(mg.e(split[0], 0));
                    }
                    if (split.length > 1) {
                        chatMessage.setHeight(mg.e(split[1], 0));
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
                if (m == null) {
                    chatImageWithTailView.getImage().G();
                    if (chatImageWithTailView.getImage() instanceof ChatClipImageItemView) {
                        chatImageWithTailView.getImage().S();
                    }
                    m.h(chatImageWithTailView.getImage());
                } else {
                    chatImageWithTailView.getImage().setImageDrawable(null);
                    chatImageWithTailView.getImage().setDefaultResource(R.drawable.pic_image_h_not);
                    chatImageWithTailView.getImage().setTag(g);
                }
                chatImageWithTailView.getImage().setDrawBorder(false);
                chatImageWithTailView.getImage().setAutoChangeStyle(false);
                if (!TextUtils.isEmpty(optString4) && !TextUtils.isEmpty(optString3) && !TextUtils.isEmpty(optString2)) {
                    if (!TextUtils.isEmpty(str) && str.endsWith("MsgleftView")) {
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                        layoutParams2.setMargins(oi.f(context, R.dimen.obfuscated_res_0x7f0701b2), 0, 0, 0);
                        layoutParams2.height = oi.f(context, R.dimen.obfuscated_res_0x7f0702ce);
                        chatImageWithTailView.getTail().setLayoutParams(layoutParams2);
                    }
                    chatImageWithTailView.getIcon().setDefaultResource(R.drawable.obfuscated_res_0x7f081833);
                    chatImageWithTailView.getIcon().K(optString2, 10, false);
                    chatImageWithTailView.getFromSource().setText(optString3);
                    chatImageWithTailView.setVisibility(0);
                    chatImageWithTailView.getTail().setVisibility(0);
                    return;
                }
                chatImageWithTailView.setVisibility(0);
            }
            m = null;
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
            if (m == null) {
            }
            chatImageWithTailView.getImage().setDrawBorder(false);
            chatImageWithTailView.getImage().setAutoChangeStyle(false);
            if (!TextUtils.isEmpty(optString4)) {
                if (!TextUtils.isEmpty(str)) {
                    LinearLayout.LayoutParams layoutParams22 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams22.setMargins(oi.f(context, R.dimen.obfuscated_res_0x7f0701b2), 0, 0, 0);
                    layoutParams22.height = oi.f(context, R.dimen.obfuscated_res_0x7f0702ce);
                    chatImageWithTailView.getTail().setLayoutParams(layoutParams22);
                }
                chatImageWithTailView.getIcon().setDefaultResource(R.drawable.obfuscated_res_0x7f081833);
                chatImageWithTailView.getIcon().K(optString2, 10, false);
                chatImageWithTailView.getFromSource().setText(optString3);
                chatImageWithTailView.setVisibility(0);
                chatImageWithTailView.getTail().setVisibility(0);
                return;
            }
            chatImageWithTailView.setVisibility(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void e(TbRichTextView tbRichTextView, ChatMessage chatMessage, String str, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(65541, null, tbRichTextView, chatMessage, str, i) == null) || chatMessage == null) {
            return;
        }
        MsgCacheData cacheData = chatMessage.getCacheData();
        if (cacheData == null) {
            cacheData = a97.h(chatMessage);
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
                    tbRichText = TbRichTextView.T(new JSONArray(chatMessage.getContent()), 7);
                } catch (Exception unused) {
                }
            }
            if (tbRichText == null) {
                tbRichText = new TbRichText(z47.d(chatMessage.getContent(), i));
            }
            cacheData.setRich_content(tbRichText);
        }
        tbRichTextView.setVisibility(0);
        tbRichTextView.setText(cacheData.getRich_content());
    }

    public static void f(Context context, ChatVoiceView chatVoiceView, ChatMessage chatMessage, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65542, null, context, chatVoiceView, chatMessage, str) == null) || chatMessage.getContent() == null || chatMessage.getContent().length() <= 0) {
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
            VoiceMsgData n = a97.n(chatMessage);
            if (n != null && n.getDuring_time() != 0.0f && cacheData.getVoice_model() == null) {
                cacheData.setVoice_model(new VoiceData.VoiceModel());
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
