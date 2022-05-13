package com.repackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.PersonPolymericActivity;
import com.baidu.tieba.personPolymeric.holder.PersonCommentHolder;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.regex.Pattern;
/* loaded from: classes5.dex */
public class d48 extends eo<PersonPostModel.PostInfoList, PersonCommentHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String i;
    public TbPageContext<PersonPolymericActivity> j;
    public boolean k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d48(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = tbPageContext;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.repackage.eo
    public /* bridge */ /* synthetic */ View S(int i, View view2, ViewGroup viewGroup, PersonPostModel.PostInfoList postInfoList, PersonCommentHolder personCommentHolder) {
        a0(i, view2, viewGroup, postInfoList, personCommentHolder);
        return view2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: Z */
    public PersonCommentHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) ? new PersonCommentHolder(LayoutInflater.from(this.j.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d06c7, viewGroup, false), this.j, this.k) : (PersonCommentHolder) invokeL.objValue;
    }

    public View a0(int i, View view2, ViewGroup viewGroup, PersonPostModel.PostInfoList postInfoList, PersonCommentHolder personCommentHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, postInfoList, personCommentHolder})) == null) {
            if (postInfoList != null && personCommentHolder != null) {
                if (this.i == null) {
                    this.i = postInfoList.user_portrait;
                }
                personCommentHolder.e(postInfoList, false, this.i);
                ArrayList<String[]> arrayList = new ArrayList<>();
                int length = postInfoList.content.length;
                for (int i2 = 0; i2 < length; i2++) {
                    if (postInfoList.content[i2].post_content.length != 0) {
                        StringBuffer stringBuffer = new StringBuffer();
                        if (!postInfoList.content[i2].post_content[0].text.startsWith("回复 ")) {
                            stringBuffer.append("回复：");
                        }
                        int length2 = postInfoList.content[i2].post_content.length;
                        for (int i3 = 0; i3 < length2; i3++) {
                            stringBuffer.append(postInfoList.content[i2].post_content[i3].text);
                        }
                        arrayList.add(new String[]{stringBuffer.toString(), String.valueOf(postInfoList.thread_id), String.valueOf(postInfoList.content[i2].post_id), String.valueOf(postInfoList.content[i2].post_type), StringHelper.getFormatTime(postInfoList.content[i2].create_time * 1000), String.valueOf(postInfoList.thread_type)});
                    }
                }
                personCommentHolder.a.setContent(arrayList);
                if (Pattern.compile("^回复：").matcher(postInfoList.title).find()) {
                    personCommentHolder.b.setText(postInfoList.title.replaceFirst("回复：", "原贴："));
                } else {
                    personCommentHolder.b.setText(postInfoList.title);
                }
                personCommentHolder.b.setTag(new String[]{String.valueOf(postInfoList.thread_id), null, null, String.valueOf(postInfoList.thread_type)});
                if (postInfoList.thread_type == 33) {
                    personCommentHolder.b.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(R.drawable.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    personCommentHolder.b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                }
                SkinManager.setBackgroundResource(personCommentHolder.b, R.drawable.person_post_line);
                SkinManager.setViewTextColor(personCommentHolder.b, R.color.common_color_10039, 1);
                int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701d5);
                personCommentHolder.b.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
                personCommentHolder.c(TbadkCoreApplication.getInst().getSkinType());
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public void b0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.k = z;
        }
    }
}
