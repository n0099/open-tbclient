package com.repackage;

import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class iq8 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d9 a;
    public List<MusicData> b;
    public int c;
    public String d;

    /* loaded from: classes6.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView a;
        public View b;
        public TextView c;

        public a(iq8 iq8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iq8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public iq8(d9 d9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {d9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = d9Var;
    }

    public void a(TextView textView, int i, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048576, this, textView, i, str) == null) || i <= 0) {
            return;
        }
        float f = pi.f(this.a.getPageActivity(), R.dimen.obfuscated_res_0x7f0702b3);
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(f);
        while (textPaint.measureText(str) > i) {
            f -= 1.0f;
            textPaint.setTextSize(f);
        }
        textView.setTextSize(0, f);
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.c : invokeV.intValue;
    }

    public List<MusicData> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.b : (List) invokeV.objValue;
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.c = i;
            notifyDataSetChanged();
        }
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.d = str;
            if (TextUtils.isEmpty(str) || this.b == null) {
                return;
            }
            int i = -1;
            for (int i2 = 0; i2 < this.b.size(); i2++) {
                if (str.equals(this.b.get(i2).id)) {
                    i = i2;
                }
            }
            if (i == -1) {
                i = 1;
            }
            this.c = i;
        }
    }

    public void f(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, list) == null) || list == null) {
            return;
        }
        this.b = list;
        e(this.d);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            List<MusicData> list = this.b;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            List<MusicData> list = this.b;
            if (list == null) {
                return null;
            }
            return list.get(i);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048585, this, i, view2, viewGroup)) == null) {
            if (view2 == null) {
                view2 = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d04a0, (ViewGroup) null);
                aVar = new a(this);
                aVar.a = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0914d2);
                aVar.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0914d6);
                aVar.b = view2.findViewById(R.id.obfuscated_res_0x7f0914d3);
                aVar.a.setDrawerType(1);
                aVar.a.setIsRound(true);
                aVar.a.setDefaultBgResource(R.color.transparent);
                aVar.a.setDefaultResource(R.drawable.obfuscated_res_0x7f0802fd);
                aVar.a.setBorderWidth(pi.f(this.a.getPageActivity(), R.dimen.obfuscated_res_0x7f070224));
                aVar.a.setBorderColor(SkinManager.getColor(R.color.CAM_X0302));
                aVar.a.setConrers(15);
                view2.setTag(aVar);
            } else {
                aVar = (a) view2.getTag();
            }
            MusicData musicData = this.b.get(i);
            if (musicData != null) {
                int i2 = musicData.editMusicType;
                if (i2 == 1) {
                    aVar.a.J(String.valueOf((int) R.drawable.obfuscated_res_0x7f080ae1), 24, false);
                } else if (i2 != 2) {
                    aVar.a.J(musicData.img, 10, false);
                } else {
                    aVar.a.J(String.valueOf((int) R.drawable.obfuscated_res_0x7f080acb), 24, false);
                }
                aVar.b.setVisibility(4);
                aVar.c.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
                aVar.c.setText(musicData.name);
                a(aVar.c, pi.f(this.a.getPageActivity(), R.dimen.obfuscated_res_0x7f07023c), musicData.name);
                if (i == this.c) {
                    aVar.a.setDrawBorder(true);
                } else {
                    aVar.a.setDrawBorder(false);
                }
                if (i == 0) {
                    view2.setPadding(pi.f(this.a.getPageActivity(), R.dimen.obfuscated_res_0x7f07020f), pi.f(this.a.getPageActivity(), R.dimen.obfuscated_res_0x7f0702c3), 0, 0);
                } else if (i == this.b.size() - 1) {
                    view2.setPadding(pi.f(this.a.getPageActivity(), R.dimen.obfuscated_res_0x7f07020f), pi.f(this.a.getPageActivity(), R.dimen.obfuscated_res_0x7f0702c3), pi.f(this.a.getPageActivity(), R.dimen.obfuscated_res_0x7f07020f), 0);
                } else {
                    view2.setPadding(pi.f(this.a.getPageActivity(), R.dimen.obfuscated_res_0x7f0701f9), pi.f(this.a.getPageActivity(), R.dimen.obfuscated_res_0x7f0702c3), 0, 0);
                }
                if (this.a.getPageActivity() instanceof BaseActivity) {
                    ((BaseActivity) this.a.getPageActivity()).getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
                    ((BaseActivity) this.a.getPageActivity()).getLayoutMode().j(view2);
                } else if (this.a.getPageActivity() instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) this.a.getPageActivity()).getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
                    ((BaseFragmentActivity) this.a.getPageActivity()).getLayoutMode().j(view2);
                }
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
