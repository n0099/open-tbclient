package d.a.q0.y0.c;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.gift.myGiftList.MyGiftListActivity;
import com.baidu.tieba.wallet.CurrencySwitchUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.j;
import d.a.d.e.p.l;
import d.a.q0.y0.b.g;
import d.a.q0.y0.c.a;
import java.util.List;
/* loaded from: classes8.dex */
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f67042e;

    /* renamed from: f  reason: collision with root package name */
    public List<a.C1856a> f67043f;

    /* renamed from: g  reason: collision with root package name */
    public MyGiftListActivity f67044g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f67045h;

    /* renamed from: i  reason: collision with root package name */
    public NoDataView f67046i;
    public boolean j;
    public int k;
    public View.OnClickListener l;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f67047e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67047e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (j.z()) {
                    this.f67047e.f67044g.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(TbadkApplication.getInst().getContext(), String.valueOf((Long) view.getTag(R.id.tag_first)), (String) view.getTag(R.id.tag_second))));
                    return;
                }
                this.f67047e.f67044g.showToast(R.string.neterror);
            }
        }
    }

    /* renamed from: d.a.q0.y0.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C1857b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f67048a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f67049b;

        /* renamed from: c  reason: collision with root package name */
        public HeadImageView f67050c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f67051d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f67052e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f67053f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f67054g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f67055h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f67056i;
        public TextView j;
        public TextView k;

        public C1857b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ C1857b(a aVar) {
            this();
        }
    }

    public b(MyGiftListActivity myGiftListActivity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {myGiftListActivity, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f67042e = 1;
        this.f67045h = false;
        this.k = -1;
        this.l = new a(this);
        this.f67044g = myGiftListActivity;
        this.j = z;
    }

    public final void b(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            this.f67044g.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
            this.f67044g.getLayoutMode().j(view);
        }
    }

    public final View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            NoDataViewFactory.c cVar = null;
            View inflate = LayoutInflater.from(this.f67044g.getPageContext().getPageActivity()).inflate(R.layout.buy_no_face_item, (ViewGroup) null);
            NoDataViewFactory.c a2 = NoDataViewFactory.c.a(new NoDataViewFactory.b(this.f67044g.getResources().getString(R.string.send_gift), this.f67044g.getSendGiftClickListener()));
            this.f67044g.getResources().getDimension(R.dimen.tbds200);
            this.f67044g.getResources().getDimension(R.dimen.ds140);
            String userSex = this.f67044g.getUserSex();
            this.f67044g.getPageContext().getString(R.string.no_gift);
            String string = this.f67044g.getPageContext().getString(R.string.come_on);
            String format = String.format(this.f67044g.getPageContext().getString(R.string.send_him_gift_note), userSex);
            Activity pageActivity = this.f67044g.getPageContext().getPageActivity();
            NoDataViewFactory.d a3 = NoDataViewFactory.d.a(NoDataViewFactory.ImgType.NODATA);
            if (!this.j) {
                string = format;
            }
            NoDataViewFactory.e d2 = NoDataViewFactory.e.d(null, string);
            if (!this.j && TbadkApplication.getInst().isGiftSwitchOn()) {
                cVar = a2;
            }
            this.f67046i = NoDataViewFactory.a(pageActivity, inflate, a3, d2, cVar);
            int skinType = TbadkApplication.getInst().getSkinType();
            this.f67044g.getLayoutMode().k(skinType == 1);
            this.f67044g.getLayoutMode().j(inflate);
            this.f67046i.f(this.f67044g.getPageContext(), skinType);
            this.f67046i.setVisibility(0);
            return inflate;
        }
        return (View) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: d */
    public a.C1856a getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            if (this.f67045h) {
                return null;
            }
            int itemId = (int) getItemId(i2);
            List<a.C1856a> list = this.f67043f;
            if (list == null || list.size() == 0 || itemId < 0 || itemId >= this.f67043f.size()) {
                return null;
            }
            return this.f67043f.get(itemId);
        }
        return (a.C1856a) invokeI.objValue;
    }

    public void e(List<a.C1856a> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, list, i2) == null) {
            if (list != null && list.size() > 0) {
                this.f67045h = false;
            } else {
                this.f67045h = true;
            }
            this.f67043f = list;
            this.k = i2;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f67045h) {
                return 1;
            }
            List<a.C1856a> list = this.f67043f;
            if (list == null || list.size() == 0) {
                return 0;
            }
            return this.f67043f.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        C1857b c1857b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i2, view, viewGroup)) == null) {
            if (this.f67045h) {
                return c();
            }
            if (view != null && view.getTag(R.id.tag_first) != null) {
                c1857b = (C1857b) view.getTag(R.id.tag_first);
            } else {
                view = LayoutInflater.from(this.f67044g.getPageContext().getPageActivity()).inflate(R.layout.my_gift_list_item, viewGroup, false);
                c1857b = new C1857b(null);
                TbImageView tbImageView = (TbImageView) view.findViewById(R.id.item_rank_image);
                c1857b.f67048a = tbImageView;
                tbImageView.setRadius(l.e(this.f67044g.getBaseContext(), 25.0f));
                c1857b.f67049b = (TextView) view.findViewById(R.id.item_rank_text);
                HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.item_portrait);
                c1857b.f67050c = headImageView;
                headImageView.setRadius(l.e(this.f67044g.getBaseContext(), 50.0f));
                c1857b.f67050c.setOnClickListener(this.l);
                c1857b.f67050c.setPlaceHolder(1);
                c1857b.f67051d = (TextView) view.findViewById(R.id.user_name);
                c1857b.f67055h = (TextView) view.findViewById(R.id.gift_num);
                c1857b.f67054g = (TextView) view.findViewById(R.id.gift_value_text);
                c1857b.f67053f = (TextView) view.findViewById(R.id.gift_name);
                c1857b.f67052e = (TextView) view.findViewById(R.id.time);
                c1857b.f67056i = (TextView) view.findViewById(R.id.paly_icon);
                c1857b.j = (TextView) view.findViewById(R.id.reward_prefix);
                c1857b.k = (TextView) view.findViewById(R.id.reward_num);
                view.setTag(R.id.tag_first, c1857b);
            }
            if (!this.j) {
                c1857b.f67052e.setVisibility(8);
                c1857b.f67056i.setVisibility(8);
            } else {
                c1857b.f67056i.setVisibility(0);
            }
            a.C1856a item = getItem(i2);
            if (item != null) {
                if (this.f67044g.userType == 1) {
                    c1857b.f67050c.M(item.f67030c, 12, false);
                    int i3 = item.j;
                    if (i3 == 1) {
                        c1857b.f67048a.setVisibility(0);
                        c1857b.f67048a.setImageResource(R.drawable.icon_frs_no1);
                        c1857b.f67049b.setVisibility(8);
                    } else if (i3 == 2) {
                        c1857b.f67048a.setVisibility(0);
                        c1857b.f67048a.setImageResource(R.drawable.icon_frs_no2);
                        c1857b.f67049b.setVisibility(8);
                    } else if (i3 == 3) {
                        c1857b.f67048a.setVisibility(0);
                        c1857b.f67048a.setImageResource(R.drawable.icon_frs_no3);
                        c1857b.f67049b.setVisibility(8);
                    } else {
                        c1857b.f67048a.setVisibility(8);
                        c1857b.f67049b.setVisibility(0);
                        TextView textView = c1857b.f67049b;
                        textView.setText(item.j + "");
                    }
                } else {
                    c1857b.f67050c.M(item.f67031d, 10, false);
                    c1857b.f67048a.setVisibility(8);
                    c1857b.f67049b.setVisibility(8);
                }
                c1857b.f67050c.setDrawBorder(false);
                c1857b.f67051d.setText(TextUtils.isEmpty(item.k) ? item.f67029b : item.k);
                c1857b.f67050c.setTag(R.id.tag_first, Long.valueOf(item.f67028a));
                c1857b.f67050c.setTag(R.id.tag_second, item.f67029b);
                c1857b.f67053f.setText(this.f67044g.getPageContext().getString(R.string.send_to_you));
                TextView textView2 = c1857b.f67054g;
                textView2.setText(this.f67044g.getPageContext().getString(R.string.gift_value) + item.f67034g);
                if (item.f67033f < 1) {
                    c1857b.f67055h.setVisibility(8);
                } else {
                    TextView textView3 = c1857b.f67055h;
                    textView3.setText(this.f67044g.getPageContext().getString(R.string.mutil_sign) + item.f67033f);
                    c1857b.f67055h.setVisibility(0);
                }
                String formatTime = StringHelper.getFormatTime(item.f67032e * 1000);
                c1857b.f67052e.setText(formatTime);
                if (CurrencySwitchUtil.isYyIsConvert(this.k)) {
                    c1857b.f67052e.setVisibility(8);
                    c1857b.f67054g.setText(formatTime);
                    SkinManager.setViewTextColor(c1857b.f67054g, R.color.CAM_X0109, 1);
                } else {
                    SkinManager.setViewTextColor(c1857b.f67054g, R.color.CAM_X0301, 1);
                }
                c1857b.j.setVisibility(0);
                c1857b.k.setVisibility(0);
                if (item.f67035h > 0) {
                    if (Integer.parseInt(item.f67036i) == 1) {
                        c1857b.k.setText(g.a(item.f67035h, 1, this.k));
                    } else if (Integer.parseInt(item.f67036i) == 2) {
                        c1857b.k.setText(g.a(item.f67035h, 2, this.k));
                    } else {
                        c1857b.j.setVisibility(8);
                        c1857b.k.setVisibility(8);
                    }
                } else {
                    c1857b.j.setVisibility(8);
                    c1857b.k.setVisibility(8);
                }
            }
            b(view);
            return view;
        }
        return (View) invokeILL.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f67042e : invokeV.intValue;
    }
}
