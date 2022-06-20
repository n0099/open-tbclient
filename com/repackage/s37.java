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
import com.baidu.tbadk.core.util.PicManager;
import com.baidu.tbadk.core.util.SkinManager;
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
/* loaded from: classes7.dex */
public class s37 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755371398, "Lcom/repackage/s37;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755371398, "Lcom/repackage/s37;");
                return;
            }
        }
        hc5.b();
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
                gifView.i0(gifInfo);
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
        m87 m87Var = new m87();
        int c = m87Var.c(chatMessage.getContent(), str);
        if (1 == m87Var.b()) {
            if (m87Var.a() != null) {
                if (c == 0) {
                    shareFromPBView.setVisibility(0);
                    shareFromPBView.setData(m87Var.a() instanceof ShareFromPBMsgData ? (ShareFromPBMsgData) m87Var.a() : null);
                } else if (c == 1) {
                    shareFromGameCenter.setVisibility(0);
                    ShareFromGameCenterMsgData shareFromGameCenterMsgData = m87Var.a() instanceof ShareFromGameCenterMsgData ? (ShareFromGameCenterMsgData) m87Var.a() : null;
                    if (!TextUtils.isEmpty(str) && str.endsWith("MsgleftView")) {
                        shareFromGameCenter.setData(shareFromGameCenterMsgData, false);
                    } else if (TextUtils.isEmpty(str) || !str.endsWith("MsgrightView")) {
                    } else {
                        shareFromGameCenter.setData(shareFromGameCenterMsgData, true);
                    }
                }
            }
        } else if (4 == m87Var.b()) {
            shareFromFrsView.setVisibility(0);
            shareFromFrsView.setData(m87Var.a() instanceof ShareFromFrsMsgData ? (ShareFromFrsMsgData) m87Var.a() : null);
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

    @SuppressLint({"ResourceAsColor"})
    public static void d(Context context, View view2, ChatImageWithTailView chatImageWithTailView, ChatMessage chatMessage, long j, String str) {
        String optString;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{context, view2, chatImageWithTailView, chatMessage, Long.valueOf(j), str}) == null) || chatMessage.getContent() == null || chatMessage.getContent().length() == 0) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONArray(chatMessage.getContent()).getJSONObject(0);
            String i = i87.i(jSONObject, false);
            String optString2 = jSONObject.optString("shareSourceIcon");
            String optString3 = jSONObject.optString("shareSource");
            String optString4 = jSONObject.optString("shareSourceUrl");
            if (i == null) {
                return;
            }
            ym ymVar = null;
            if (i.startsWith("http")) {
                chatImageWithTailView.getImage().j0(i, 38);
            } else {
                try {
                    ym m = j35.k().m(i);
                    if (m == null) {
                        Bitmap reSizeBitmap = PicManager.getInstance().getReSizeBitmap(hi.d().c(i));
                        if (reSizeBitmap != null) {
                            ym ymVar2 = new ym(reSizeBitmap, false);
                            try {
                                if (chatMessage.getWidth() < 1) {
                                    chatMessage.setWidth(ymVar2.r());
                                    chatMessage.setHeight(ymVar2.m());
                                }
                                j35.k().d(i, ymVar2);
                            } catch (Exception unused) {
                            }
                            ymVar = ymVar2;
                        }
                    } else {
                        try {
                            if (chatMessage.getWidth() < 1) {
                                chatMessage.setWidth(m.r());
                                chatMessage.setHeight(m.m());
                            }
                        } catch (Exception unused2) {
                        }
                        ymVar = m;
                    }
                } catch (Exception unused3) {
                }
            }
            if (chatMessage.getWidth() < 1 && (optString = jSONObject.optString("bsize")) != null) {
                String[] split = optString.split(",");
                if (split.length > 0) {
                    chatMessage.setWidth(ng.e(split[0], 0));
                }
                if (split.length > 1) {
                    chatMessage.setHeight(ng.e(split[1], 0));
                }
            }
            IMImageSize chatImageSize = PicManager.getInstance().getChatImageSize(chatMessage.getWidth(), chatMessage.getHeight());
            ViewGroup.LayoutParams layoutParams = chatImageWithTailView.getImage().getLayoutParams();
            layoutParams.height = chatImageSize.height;
            layoutParams.width = chatImageSize.width;
            chatImageWithTailView.getImage().setLayoutParams(layoutParams);
            if (ymVar != null) {
                chatImageWithTailView.getImage().F();
                chatImageWithTailView.getImage().Y();
                ymVar.h(chatImageWithTailView.getImage());
            } else {
                chatImageWithTailView.getImage().setDefaultResource(SkinManager.getResourceId(R.drawable.icon_pic_im_image_default));
                chatImageWithTailView.getImage().setTag(i);
            }
            chatImageWithTailView.getImage().setAutoChangeStyle(true);
            if (!TextUtils.isEmpty(optString4) && !TextUtils.isEmpty(optString3) && !TextUtils.isEmpty(optString2)) {
                if (!TextUtils.isEmpty(str) && str.endsWith("MsgleftView")) {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.setMargins(pi.f(context, R.dimen.obfuscated_res_0x7f0701b2), 0, 0, 0);
                    layoutParams2.height = pi.f(context, R.dimen.obfuscated_res_0x7f0702ce);
                    chatImageWithTailView.getTail().setLayoutParams(layoutParams2);
                }
                chatImageWithTailView.getIcon().setDefaultResource(R.drawable.obfuscated_res_0x7f081833);
                chatImageWithTailView.getIcon().J(optString2, 10, false);
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
            cacheData = i87.j(chatMessage);
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
                tbRichText = new TbRichText(l37.c(chatMessage.getContent(), i));
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
            VoiceMsgData p = i87.p(chatMessage);
            if (p != null && p.getDuring_time() != 0.0f && cacheData.getVoice_model() == null) {
                cacheData.setVoice_model(new VoiceData.VoiceModel());
                cacheData.getVoice_model().voiceId = p.getVoice_md5();
                cacheData.getVoice_model().duration = Math.round(p.getDuring_time());
            }
            chatVoiceView.setTag(null);
            chatVoiceView.setData(chatMessage);
            chatVoiceView.setVisibility(0);
        } catch (Exception unused) {
        }
    }
}
