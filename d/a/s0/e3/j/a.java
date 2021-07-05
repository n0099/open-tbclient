package d.a.s0.e3.j;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumListActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.square.square.BarFolderFirstDirActivity;
import com.baidu.tieba.square.view.BestStringsFitTextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Activity f59256e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<d> f59257f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f59258g;

    /* renamed from: d.a.s0.e3.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class View$OnClickListenerC1412a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f59259e;

        public View$OnClickListenerC1412a(a aVar) {
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
            this.f59259e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d dVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                Object tag = view.getTag();
                if ((tag instanceof b) && (dVar = ((b) tag).f59263d) != null) {
                    if (dVar.f59266a == null) {
                        BarFolderFirstDirActivity.k(this.f59259e.c(), null);
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2902025, new ForumListActivityConfig(this.f59259e.c(), dVar.f59267b, dVar.f59266a, dVar.f59268c)));
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public BarImageView f59260a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f59261b;

        /* renamed from: c  reason: collision with root package name */
        public BestStringsFitTextView f59262c;

        /* renamed from: d  reason: collision with root package name */
        public d f59263d;

        public b() {
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
    }

    public a(Activity activity, d.a.s0.e3.j.b bVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, bVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59258g = new View$OnClickListenerC1412a(this);
        this.f59256e = activity;
        this.f59257f = bVar.h();
    }

    public final View a(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, viewGroup, i2)) == null) {
            if (i2 == 3) {
                return LayoutInflater.from(this.f59256e).inflate(R.layout.bar_home_list_line, viewGroup, false);
            }
            if (i2 == 2) {
                return LayoutInflater.from(this.f59256e).inflate(R.layout.bar_folder_first_dir_bottom_item, viewGroup, false);
            }
            View inflate = LayoutInflater.from(this.f59256e).inflate(R.layout.bar_folder_first_dir_item, viewGroup, false);
            inflate.setOnClickListener(this.f59258g);
            b bVar = new b();
            bVar.f59260a = (BarImageView) inflate.findViewById(R.id.portrait);
            bVar.f59261b = (TextView) inflate.findViewById(R.id.name);
            bVar.f59262c = (BestStringsFitTextView) inflate.findViewById(R.id.description);
            inflate.setTag(bVar);
            return inflate;
        }
        return (View) invokeLI.objValue;
    }

    public final void b(ViewGroup viewGroup, b bVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, bVar, i2) == null) {
            d dVar = this.f59257f.get(i2 / 2);
            bVar.f59263d = dVar;
            bVar.f59261b.setText(dVar.f59267b);
            if (dVar.f59270e != null) {
                bVar.f59262c.setVisibility(0);
                String[] strArr = new String[dVar.f59270e.size()];
                for (int i3 = 0; i3 < dVar.f59270e.size(); i3++) {
                    strArr[i3] = dVar.f59270e.get(i3).f59267b;
                }
                bVar.f59262c.setTextArray(strArr);
            } else {
                bVar.f59262c.setVisibility(8);
            }
            if (dVar.f59269d != null) {
                int e2 = l.e(this.f59256e, 45.0f);
                bVar.f59260a.setTag(dVar.f59269d);
                bVar.f59260a.J(dVar.f59269d, 10, e2, e2, false);
            }
        }
    }

    public Activity c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f59256e : (Activity) invokeV.objValue;
    }

    public ArrayList<d> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f59257f : (ArrayList) invokeV.objValue;
    }

    public void e(ArrayList<d> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, arrayList) == null) {
            this.f59257f = arrayList;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ArrayList<d> arrayList = this.f59257f;
            if (arrayList == null) {
                return 0;
            }
            return (arrayList.size() * 2) + 1;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            return null;
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            if (getCount() <= 0 || i2 != getCount() - 1) {
                return Math.abs(i2) % 2 == 1 ? 3 : 1;
            }
            return 2;
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048585, this, i2, view, viewGroup)) == null) {
            int itemViewType = getItemViewType(i2);
            if (view == null) {
                view = a(viewGroup, itemViewType);
                ViewHelper.prepareNewView(view);
            }
            ViewHelper.processCurrentSkin(view);
            if (itemViewType == 3) {
                return view;
            }
            TbadkCoreApplication.getInst().getSkinType();
            View findViewById = view.findViewById(R.id.container);
            SkinManager.setBackgroundResource(findViewById, R.drawable.addresslist_item_bg);
            if (itemViewType == 2) {
                if (getCount() > 1) {
                    findViewById.setVisibility(0);
                }
            } else if (itemViewType == 1) {
                b(viewGroup, (b) view.getTag(), i2);
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return 4;
        }
        return invokeV.intValue;
    }
}
