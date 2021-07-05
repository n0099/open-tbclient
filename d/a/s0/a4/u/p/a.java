package d.a.s0.a4.u.p;

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
import d.a.r0.r.s.a;
import java.util.ArrayList;
import java.util.Calendar;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<WriteActivity> f57745a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f57746b;

    /* renamed from: c  reason: collision with root package name */
    public VoteView f57747c;

    /* renamed from: d  reason: collision with root package name */
    public WriteVoteData f57748d;

    /* renamed from: d.a.s0.a4.u.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class View$OnClickListenerC1327a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f57749e;

        /* renamed from: d.a.s0.a4.u.p.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C1328a implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ View$OnClickListenerC1327a f57750e;

            public C1328a(View$OnClickListenerC1327a view$OnClickListenerC1327a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {view$OnClickListenerC1327a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f57750e = view$OnClickListenerC1327a;
            }

            @Override // d.a.r0.r.s.a.e
            public void onClick(d.a.r0.r.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    this.f57750e.f57749e.f57748d = null;
                    this.f57750e.f57749e.h(false);
                    aVar.dismiss();
                }
            }
        }

        /* renamed from: d.a.s0.a4.u.p.a$a$b */
        /* loaded from: classes9.dex */
        public class b implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(View$OnClickListenerC1327a view$OnClickListenerC1327a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {view$OnClickListenerC1327a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // d.a.r0.r.s.a.e
            public void onClick(d.a.r0.r.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                }
            }
        }

        public View$OnClickListenerC1327a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57749e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                d.a.r0.r.s.a aVar = new d.a.r0.r.s.a(this.f57749e.f57745a.getPageActivity());
                aVar.setTitle(this.f57749e.f57745a.getString(R.string.vote_delete_dialog_title));
                aVar.setTitleShowCenter(true);
                aVar.setMessage(this.f57749e.f57745a.getString(R.string.vote_delete_dialog_message));
                aVar.setMessageShowCenter(true);
                aVar.setPositiveButton(R.string.delete, new C1328a(this));
                aVar.setNegativeButton(R.string.cancel, new b(this));
                aVar.create(this.f57749e.f57745a).show();
            }
        }
    }

    public a(TbPageContext<WriteActivity> tbPageContext, RelativeLayout relativeLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, relativeLayout};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f57745a = tbPageContext;
        this.f57746b = relativeLayout;
        VoteView voteView = new VoteView(this.f57745a.getPageActivity());
        this.f57747c = voteView;
        voteView.setPageContext(this.f57745a);
        this.f57747c.setDeleteOnClickListener(new View$OnClickListenerC1327a(this));
        this.f57747c.setVoteViewDeleteVisibility(0);
        this.f57746b.addView(this.f57747c);
        h(false);
    }

    public WriteVoteData c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f57748d : (WriteVoteData) invokeV.objValue;
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f57747c.C(i2);
        }
    }

    public void e(View.OnClickListener onClickListener) {
        VoteView voteView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) || (voteView = this.f57747c) == null || onClickListener == null) {
            return;
        }
        voteView.setOnItemClickListener(onClickListener);
    }

    public void f(View.OnClickListener onClickListener) {
        VoteView voteView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) || (voteView = this.f57747c) == null || onClickListener == null) {
            return;
        }
        voteView.setOnClickListener(onClickListener);
    }

    public void g(WriteVoteData writeVoteData) {
        VoteView voteView;
        TbPageContext<WriteActivity> tbPageContext;
        int i2;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, writeVoteData) == null) || writeVoteData == null || (voteView = this.f57747c) == null) {
            return;
        }
        this.f57748d = writeVoteData;
        voteView.setVoteTitle(writeVoteData.getTitle());
        if (this.f57748d.getIs_multi() == 1) {
            tbPageContext = this.f57745a;
            i2 = R.string.vote_type_multiple;
        } else {
            tbPageContext = this.f57745a;
            i2 = R.string.vote_type_single;
        }
        String string = tbPageContext.getString(i2);
        int expire_type = this.f57748d.getExpire_type();
        if (expire_type > 0) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(6, expire_type);
            str = String.format(this.f57745a.getString(R.string.write_vote_content_time), Integer.valueOf(calendar.get(2) + 1), Integer.valueOf(calendar.get(5)));
        } else {
            str = "";
        }
        if (StringUtils.isNull(str)) {
            this.f57747c.setVoteSubContent(string);
        } else {
            VoteView voteView2 = this.f57747c;
            voteView2.setVoteSubContent(string + " · " + str);
        }
        ArrayList arrayList = new ArrayList();
        for (WriteVoteItemData writeVoteItemData : this.f57748d.getOptions()) {
            PollOptionData pollOptionData = new PollOptionData();
            pollOptionData.setId(writeVoteItemData.getId());
            pollOptionData.setText(writeVoteItemData.getText());
            arrayList.add(pollOptionData);
        }
        if (ListUtils.isEmpty(arrayList)) {
            return;
        }
        if (arrayList.size() > 3) {
            this.f57747c.setData(arrayList.subList(0, 3));
        } else {
            this.f57747c.setData(arrayList);
        }
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f57746b.setVisibility(z ? 0 : 8);
        }
    }
}
