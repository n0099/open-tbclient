package com.repackage;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalForumInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class ox5 extends tw5<ThreadData> implements pi5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final View i;
    public TbPageContext<?> j;
    public HeadImageView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public ThreadData o;
    public nx5 p;
    public ConstrainImageGroup q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ox5(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viewGroup};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (ViewGroup) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        View k = k();
        k.setOnClickListener(this);
        this.j = tbPageContext;
        HeadImageView headImageView = (HeadImageView) k.findViewById(R.id.obfuscated_res_0x7f0920d6);
        this.k = headImageView;
        headImageView.setIsRound(true);
        this.k.setDefaultResource(R.drawable.obfuscated_res_0x7f080f20);
        this.l = (TextView) k.findViewById(R.id.obfuscated_res_0x7f09058e);
        this.n = (TextView) k.findViewById(R.id.obfuscated_res_0x7f09057f);
        this.m = (TextView) k.findViewById(R.id.obfuscated_res_0x7f09057a);
        this.q = (ConstrainImageGroup) k.findViewById(R.id.obfuscated_res_0x7f090552);
        this.i = k.findViewById(R.id.obfuscated_res_0x7f0904fd);
        this.q.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        re5 re5Var = new re5(3);
        re5Var.d(1.0d);
        this.q.setImageProcessor(re5Var);
        this.q.setSinglePicUseStyleV10(true);
        this.q.setFromCDN(true);
        this.q.setClickable(false);
    }

    @Override // com.repackage.pi5
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
        }
    }

    @Override // com.repackage.tw5
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? R.layout.obfuscated_res_0x7f0d032d : invokeV.intValue;
    }

    @Override // com.repackage.tw5
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i) == null) {
            this.k.invalidate();
            SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0109);
            SkinManager.setBackgroundResource(k(), R.drawable.addresslist_item_bg);
            SkinManager.setBackgroundColor(this.i, R.color.CAM_X0204);
            this.q.b();
            this.k.setDefaultBgResource(i);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, view2) == null) || this.o == null) {
            return;
        }
        if (e() != null) {
            e().b(view2, this.o, this.p);
        }
        if (view2 == k()) {
            ex5.a(this.o.getTid());
            ex5.l(this.n, this.o.getTid(), R.color.CAM_X0105, R.color.CAM_X0109);
            s();
        }
    }

    public final void s() {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (threadData = this.o) == null || threadData.getAuthor() == null || this.o.getAuthor().getName_show() == null) {
            return;
        }
        long fid = this.o.getFid();
        OriginalForumInfo originalForumInfo = this.o.mOriginalForumInfo;
        if (originalForumInfo != null) {
            fid = mg.g(originalForumInfo.id, 0L);
        }
        long j = fid;
        String name_show = this.o.getAuthor().getName_show();
        HotTopicActivityConfig hotTopicActivityConfig = new HotTopicActivityConfig(getContext());
        HotTopicActivityConfig createNormalConfig = hotTopicActivityConfig.createNormalConfig("", name_show + "", "3");
        createNormalConfig.setExtra(j, this.o.getFirstClassName(), this.o.getSecondClassName(), mg.g(this.o.getTid(), 0L));
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.tw5
    /* renamed from: t */
    public void l(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, threadData) == null) {
            if (threadData == null) {
                if (k() != null) {
                    k().setVisibility(8);
                    return;
                }
                return;
            }
            this.o = threadData;
            if (k() != null) {
                k().setVisibility(0);
                k().setOnClickListener(this);
            }
            if (threadData.getAuthor() != null) {
                this.l.setText(threadData.getAuthor().getName_show());
            }
            this.m.setText(StringHelper.getFormatTime(threadData.getLast_time_int() * 1000));
            String str = threadData.getTopicUserName() + "：";
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.append((CharSequence) threadData.parseTitleOrAbstractForFrsNew(false, true));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0304)), 0, str.length(), 33);
            this.n.setText(spannableStringBuilder);
            ArrayList<MediaData> medias = threadData.getMedias();
            if (bn4.c().g() && ListUtils.getCount(medias) != 0) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < medias.size(); i++) {
                    MediaData mediaData = (MediaData) ListUtils.getItem(medias, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        arrayList.add(mediaData);
                    }
                }
                if (ListUtils.getCount(arrayList) > 0) {
                    this.q.setVisibility(0);
                    this.q.setImageMediaList(arrayList);
                } else {
                    this.q.setVisibility(8);
                }
            } else {
                this.q.setVisibility(8);
            }
            ex5.l(this.n, this.o.getTid(), R.color.CAM_X0105, R.color.CAM_X0109);
            m(this.j, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void u(dg<TbImageView> dgVar) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, dgVar) == null) || (constrainImageGroup = this.q) == null) {
            return;
        }
        constrainImageGroup.setImageViewPool(dgVar);
    }

    public void v(dg<ConstrainImageLayout> dgVar) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dgVar) == null) || (constrainImageGroup = this.q) == null) {
            return;
        }
        constrainImageGroup.setConstrainLayoutPool(dgVar);
    }
}
