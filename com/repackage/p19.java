package com.repackage;

import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.PollOptionData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.VoteView;
import com.baidu.tbadk.coreExtra.data.WriteVoteData;
import com.baidu.tbadk.coreExtra.data.WriteVoteItemData;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.WriteActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cr4;
import java.util.ArrayList;
import java.util.Calendar;
/* loaded from: classes6.dex */
public class p19 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<WriteActivity> a;
    public RelativeLayout b;
    public VoteView c;
    public WriteVoteData d;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p19 a;

        /* renamed from: com.repackage.p19$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0491a implements cr4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0491a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // com.repackage.cr4.e
            public void onClick(cr4 cr4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                    this.a.a.d = null;
                    this.a.a.h(false);
                    cr4Var.dismiss();
                }
            }
        }

        /* loaded from: classes6.dex */
        public class b implements cr4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.repackage.cr4.e
            public void onClick(cr4 cr4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                    cr4Var.dismiss();
                }
            }
        }

        public a(p19 p19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p19Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                cr4 cr4Var = new cr4(this.a.a.getPageActivity());
                cr4Var.setTitle(this.a.a.getString(R.string.obfuscated_res_0x7f0f1537));
                cr4Var.setTitleShowCenter(true);
                cr4Var.setMessage(this.a.a.getString(R.string.obfuscated_res_0x7f0f1536));
                cr4Var.setMessageShowCenter(true);
                cr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0495, new C0491a(this));
                cr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f036e, new b(this));
                cr4Var.create(this.a.a).show();
            }
        }
    }

    public p19(TbPageContext<WriteActivity> tbPageContext, RelativeLayout relativeLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, relativeLayout};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        this.b = relativeLayout;
        VoteView voteView = new VoteView(this.a.getPageActivity());
        this.c = voteView;
        voteView.setPageContext(this.a);
        this.c.setDeleteOnClickListener(new a(this));
        this.c.setVoteViewDeleteVisibility(0);
        this.b.addView(this.c);
        h(false);
    }

    public WriteVoteData c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.d : (WriteVoteData) invokeV.objValue;
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.c.C(i);
        }
    }

    public void e(View.OnClickListener onClickListener) {
        VoteView voteView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) || (voteView = this.c) == null || onClickListener == null) {
            return;
        }
        voteView.setOnItemClickListener(onClickListener);
    }

    public void f(View.OnClickListener onClickListener) {
        VoteView voteView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) || (voteView = this.c) == null || onClickListener == null) {
            return;
        }
        voteView.setOnClickListener(onClickListener);
    }

    public void g(WriteVoteData writeVoteData) {
        VoteView voteView;
        TbPageContext<WriteActivity> tbPageContext;
        int i;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, writeVoteData) == null) || writeVoteData == null || (voteView = this.c) == null) {
            return;
        }
        this.d = writeVoteData;
        voteView.setVoteTitle(writeVoteData.getTitle());
        if (this.d.getIs_multi() == 1) {
            tbPageContext = this.a;
            i = R.string.obfuscated_res_0x7f0f1542;
        } else {
            tbPageContext = this.a;
            i = R.string.obfuscated_res_0x7f0f1543;
        }
        String string = tbPageContext.getString(i);
        int expire_type = this.d.getExpire_type();
        if (expire_type > 0) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(6, expire_type);
            str = String.format(this.a.getString(R.string.obfuscated_res_0x7f0f159e), Integer.valueOf(calendar.get(2) + 1), Integer.valueOf(calendar.get(5)));
        } else {
            str = "";
        }
        if (StringUtils.isNull(str)) {
            this.c.setVoteSubContent(string);
        } else {
            VoteView voteView2 = this.c;
            voteView2.setVoteSubContent(string + " · " + str);
        }
        ArrayList arrayList = new ArrayList();
        for (WriteVoteItemData writeVoteItemData : this.d.getOptions()) {
            PollOptionData pollOptionData = new PollOptionData();
            pollOptionData.setId(writeVoteItemData.getId());
            pollOptionData.setText(writeVoteItemData.getText());
            arrayList.add(pollOptionData);
        }
        if (ListUtils.isEmpty(arrayList)) {
            return;
        }
        if (arrayList.size() > 3) {
            this.c.setData(arrayList.subList(0, 3));
        } else {
            this.c.setData(arrayList);
        }
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.b.setVisibility(z ? 0 : 8);
            this.a.getOrignalPage().changeToolButtonStatus();
            this.a.getOrignalPage().upDateVoteInfo(this.d);
        }
    }
}
