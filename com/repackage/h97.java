package com.repackage;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.emoji.ImEmojiUtil;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class h97 implements i97 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, Integer> a;

    public h97() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        HashMap<String, Integer> hashMap = new HashMap<>(6);
        this.a = hashMap;
        hashMap.put("#(呵呵)_#(炸药)", Integer.valueOf(ImEmojiUtil.d));
        this.a.put("#(哈哈)_#(炸药)", Integer.valueOf(ImEmojiUtil.d));
        this.a.put("#(吐舌)_#(炸药)", Integer.valueOf(ImEmojiUtil.d));
        this.a.put("#(太开心)_#(炸药)", Integer.valueOf(ImEmojiUtil.d));
        this.a.put("#(笑眼)_#(炸药)", Integer.valueOf(ImEmojiUtil.d));
        this.a.put("#(花心)_#(炸药)", Integer.valueOf(ImEmojiUtil.d));
    }

    @Override // com.repackage.i97
    public boolean a(ChatMessage... chatMessageArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, chatMessageArr)) == null) {
            if (chatMessageArr != null && chatMessageArr.length >= 2) {
                ChatMessage chatMessage = chatMessageArr[0];
                ChatMessage chatMessage2 = chatMessageArr[1];
                if (chatMessage == null || chatMessage.getUserInfo() == null || chatMessage2 == null || chatMessage2.getUserInfo() == null || StringHelper.equals(chatMessage.getUserInfo().getUserId(), chatMessage2.getUserInfo().getUserId())) {
                    return false;
                }
                return this.a.containsKey(c(chatMessageArr));
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.i97
    public void b(ListView listView, ChatMessage... chatMessageArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, listView, chatMessageArr) == null) || listView == null) {
            return;
        }
        int lastVisiblePosition = listView.getLastVisiblePosition() - listView.getFirstVisiblePosition();
        View childAt = listView.getChildAt(lastVisiblePosition);
        View childAt2 = listView.getChildAt(lastVisiblePosition - 1);
        if (childAt == null || childAt2 == null) {
            return;
        }
        TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(R.id.obfuscated_res_0x7f091fa9);
        TbRichTextView tbRichTextView2 = (TbRichTextView) childAt2.findViewById(R.id.obfuscated_res_0x7f091fa9);
        if (chatMessageArr == null || chatMessageArr.length <= 1) {
            return;
        }
        ImEmojiUtil.m(listView.getContext(), (FrameLayout) listView.getRootView().findViewById(16908290), this.a.get(c(chatMessageArr)).intValue(), tbRichTextView, tbRichTextView2);
    }

    public final String c(ChatMessage... chatMessageArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, chatMessageArr)) == null) {
            if (chatMessageArr == null || chatMessageArr.length <= 1 || chatMessageArr[0] == null || chatMessageArr[1] == null) {
                return null;
            }
            return chatMessageArr[1].getContent() + "_" + chatMessageArr[0].getContent();
        }
        return (String) invokeL.objValue;
    }
}
