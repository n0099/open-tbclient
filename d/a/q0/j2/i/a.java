package d.a.q0.j2.i;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.BookInfo;
import tbclient.TbBookrack;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f59755a;

    /* renamed from: b  reason: collision with root package name */
    public int f59756b;

    /* renamed from: c  reason: collision with root package name */
    public List<b> f59757c;

    /* renamed from: d  reason: collision with root package name */
    public String f59758d;

    /* renamed from: e  reason: collision with root package name */
    public String f59759e;

    /* renamed from: f  reason: collision with root package name */
    public String f59760f;

    public a() {
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

    public void a(TbBookrack tbBookrack) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, tbBookrack) == null) || tbBookrack == null) {
            return;
        }
        this.f59755a = tbBookrack.booktown;
        this.f59756b = tbBookrack.num.intValue();
        this.f59758d = tbBookrack.title;
        this.f59759e = tbBookrack.icon;
        this.f59760f = tbBookrack.tip;
        this.f59757c = new ArrayList();
        List<BookInfo> list = tbBookrack.book_list;
        if (list != null) {
            for (BookInfo bookInfo : list) {
                if (bookInfo != null) {
                    b bVar = new b();
                    bVar.a(bookInfo);
                    this.f59757c.add(bVar);
                }
            }
        }
    }
}
