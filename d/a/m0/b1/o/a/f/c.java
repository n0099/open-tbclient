package d.a.m0.b1.o.a.f;

import android.view.View;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import com.baidu.tieba.R;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.tencent.connect.common.Constants;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    public static DateFormat y = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /* renamed from: a  reason: collision with root package name */
    public View f49173a;

    /* renamed from: b  reason: collision with root package name */
    public WheelView f49174b;

    /* renamed from: c  reason: collision with root package name */
    public WheelView f49175c;

    /* renamed from: d  reason: collision with root package name */
    public WheelView f49176d;

    /* renamed from: e  reason: collision with root package name */
    public WheelView f49177e;

    /* renamed from: f  reason: collision with root package name */
    public WheelView f49178f;

    /* renamed from: g  reason: collision with root package name */
    public WheelView f49179g;

    /* renamed from: h  reason: collision with root package name */
    public int f49180h;

    /* renamed from: i  reason: collision with root package name */
    public boolean[] f49181i;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public float u;
    public WheelView.DividerType v;
    public d.a.m0.b1.o.a.d.b x;
    public int j = 1900;
    public int k = 2100;
    public int l = 1;
    public int m = 12;
    public int n = 1;
    public int o = 31;
    public boolean w = false;

    /* loaded from: classes3.dex */
    public class a implements d.a.m0.b1.o.b.c.b {
        public a() {
        }

        @Override // d.a.m0.b1.o.b.c.b
        public void a(int i2) {
            int h2;
            int i3 = i2 + c.this.j;
            c.this.f49175c.setAdapter(new d.a.m0.b1.o.a.a.a(d.a.m0.b1.o.a.e.a.d(i3)));
            if (d.a.m0.b1.o.a.e.a.g(i3) == 0 || c.this.f49175c.getCurrentItem() <= d.a.m0.b1.o.a.e.a.g(i3) - 1) {
                c.this.f49175c.setCurrentItem(c.this.f49175c.getCurrentItem());
            } else {
                c.this.f49175c.setCurrentItem(c.this.f49175c.getCurrentItem() + 1);
            }
            if (d.a.m0.b1.o.a.e.a.g(i3) == 0 || c.this.f49175c.getCurrentItem() <= d.a.m0.b1.o.a.e.a.g(i3) - 1) {
                c.this.f49176d.setAdapter(new d.a.m0.b1.o.a.a.a(d.a.m0.b1.o.a.e.a.b(d.a.m0.b1.o.a.e.a.h(i3, c.this.f49175c.getCurrentItem() + 1))));
                h2 = d.a.m0.b1.o.a.e.a.h(i3, c.this.f49175c.getCurrentItem() + 1);
            } else if (c.this.f49175c.getCurrentItem() == d.a.m0.b1.o.a.e.a.g(i3) + 1) {
                c.this.f49176d.setAdapter(new d.a.m0.b1.o.a.a.a(d.a.m0.b1.o.a.e.a.b(d.a.m0.b1.o.a.e.a.f(i3))));
                h2 = d.a.m0.b1.o.a.e.a.f(i3);
            } else {
                c.this.f49176d.setAdapter(new d.a.m0.b1.o.a.a.a(d.a.m0.b1.o.a.e.a.b(d.a.m0.b1.o.a.e.a.h(i3, c.this.f49175c.getCurrentItem()))));
                h2 = d.a.m0.b1.o.a.e.a.h(i3, c.this.f49175c.getCurrentItem());
            }
            int i4 = h2 - 1;
            if (c.this.f49176d.getCurrentItem() > i4) {
                c.this.f49176d.setCurrentItem(i4);
            }
            if (c.this.x != null) {
                c.this.x.a();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.m0.b1.o.b.c.b {
        public b() {
        }

        @Override // d.a.m0.b1.o.b.c.b
        public void a(int i2) {
            int h2;
            int currentItem = c.this.f49174b.getCurrentItem() + c.this.j;
            if (d.a.m0.b1.o.a.e.a.g(currentItem) == 0 || i2 <= d.a.m0.b1.o.a.e.a.g(currentItem) - 1) {
                int i3 = i2 + 1;
                c.this.f49176d.setAdapter(new d.a.m0.b1.o.a.a.a(d.a.m0.b1.o.a.e.a.b(d.a.m0.b1.o.a.e.a.h(currentItem, i3))));
                h2 = d.a.m0.b1.o.a.e.a.h(currentItem, i3);
            } else if (c.this.f49175c.getCurrentItem() == d.a.m0.b1.o.a.e.a.g(currentItem) + 1) {
                c.this.f49176d.setAdapter(new d.a.m0.b1.o.a.a.a(d.a.m0.b1.o.a.e.a.b(d.a.m0.b1.o.a.e.a.f(currentItem))));
                h2 = d.a.m0.b1.o.a.e.a.f(currentItem);
            } else {
                c.this.f49176d.setAdapter(new d.a.m0.b1.o.a.a.a(d.a.m0.b1.o.a.e.a.b(d.a.m0.b1.o.a.e.a.h(currentItem, i2))));
                h2 = d.a.m0.b1.o.a.e.a.h(currentItem, i2);
            }
            int i4 = h2 - 1;
            if (c.this.f49176d.getCurrentItem() > i4) {
                c.this.f49176d.setCurrentItem(i4);
            }
            if (c.this.x != null) {
                c.this.x.a();
            }
        }
    }

    /* renamed from: d.a.m0.b1.o.a.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1114c implements d.a.m0.b1.o.b.c.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f49184a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f49185b;

        public C1114c(List list, List list2) {
            this.f49184a = list;
            this.f49185b = list2;
        }

        @Override // d.a.m0.b1.o.b.c.b
        public void a(int i2) {
            int i3 = i2 + c.this.j;
            c.this.p = i3;
            int currentItem = c.this.f49175c.getCurrentItem();
            if (c.this.j == c.this.k) {
                c.this.f49175c.setAdapter(new d.a.m0.b1.o.a.a.b(c.this.l, c.this.m));
                if (currentItem > c.this.f49175c.getAdapter().a() - 1) {
                    currentItem = c.this.f49175c.getAdapter().a() - 1;
                    c.this.f49175c.setCurrentItem(currentItem);
                }
                int i4 = currentItem + c.this.l;
                if (c.this.l != c.this.m) {
                    if (i4 != c.this.l) {
                        if (i4 != c.this.m) {
                            c.this.F(i3, i4, 1, 31, this.f49184a, this.f49185b);
                        } else {
                            c cVar = c.this;
                            cVar.F(i3, i4, 1, cVar.o, this.f49184a, this.f49185b);
                        }
                    } else {
                        c cVar2 = c.this;
                        cVar2.F(i3, i4, cVar2.n, 31, this.f49184a, this.f49185b);
                    }
                } else {
                    c cVar3 = c.this;
                    cVar3.F(i3, i4, cVar3.n, c.this.o, this.f49184a, this.f49185b);
                }
            } else if (i3 == c.this.j) {
                c.this.f49175c.setAdapter(new d.a.m0.b1.o.a.a.b(c.this.l, 12));
                if (currentItem > c.this.f49175c.getAdapter().a() - 1) {
                    currentItem = c.this.f49175c.getAdapter().a() - 1;
                    c.this.f49175c.setCurrentItem(currentItem);
                }
                int i5 = currentItem + c.this.l;
                if (i5 != c.this.l) {
                    c.this.F(i3, i5, 1, 31, this.f49184a, this.f49185b);
                } else {
                    c cVar4 = c.this;
                    cVar4.F(i3, i5, cVar4.n, 31, this.f49184a, this.f49185b);
                }
            } else if (i3 == c.this.k) {
                c.this.f49175c.setAdapter(new d.a.m0.b1.o.a.a.b(1, c.this.m));
                if (currentItem > c.this.f49175c.getAdapter().a() - 1) {
                    currentItem = c.this.f49175c.getAdapter().a() - 1;
                    c.this.f49175c.setCurrentItem(currentItem);
                }
                int i6 = 1 + currentItem;
                if (i6 != c.this.m) {
                    c.this.F(i3, i6, 1, 31, this.f49184a, this.f49185b);
                } else {
                    c cVar5 = c.this;
                    cVar5.F(i3, i6, 1, cVar5.o, this.f49184a, this.f49185b);
                }
            } else {
                c.this.f49175c.setAdapter(new d.a.m0.b1.o.a.a.b(1, 12));
                c cVar6 = c.this;
                cVar6.F(i3, 1 + cVar6.f49175c.getCurrentItem(), 1, 31, this.f49184a, this.f49185b);
            }
            if (c.this.x != null) {
                c.this.x.a();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements d.a.m0.b1.o.b.c.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f49187a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f49188b;

        public d(List list, List list2) {
            this.f49187a = list;
            this.f49188b = list2;
        }

        @Override // d.a.m0.b1.o.b.c.b
        public void a(int i2) {
            int i3 = i2 + 1;
            if (c.this.j == c.this.k) {
                int i4 = (i3 + c.this.l) - 1;
                if (c.this.l != c.this.m) {
                    if (c.this.l != i4) {
                        if (c.this.m == i4) {
                            c cVar = c.this;
                            cVar.F(cVar.p, i4, 1, c.this.o, this.f49187a, this.f49188b);
                        } else {
                            c cVar2 = c.this;
                            cVar2.F(cVar2.p, i4, 1, 31, this.f49187a, this.f49188b);
                        }
                    } else {
                        c cVar3 = c.this;
                        cVar3.F(cVar3.p, i4, c.this.n, 31, this.f49187a, this.f49188b);
                    }
                } else {
                    c cVar4 = c.this;
                    cVar4.F(cVar4.p, i4, c.this.n, c.this.o, this.f49187a, this.f49188b);
                }
            } else if (c.this.p == c.this.j) {
                int i5 = (i3 + c.this.l) - 1;
                if (i5 == c.this.l) {
                    c cVar5 = c.this;
                    cVar5.F(cVar5.p, i5, c.this.n, 31, this.f49187a, this.f49188b);
                } else {
                    c cVar6 = c.this;
                    cVar6.F(cVar6.p, i5, 1, 31, this.f49187a, this.f49188b);
                }
            } else if (c.this.p == c.this.k) {
                if (i3 == c.this.m) {
                    c cVar7 = c.this;
                    cVar7.F(cVar7.p, c.this.f49175c.getCurrentItem() + 1, 1, c.this.o, this.f49187a, this.f49188b);
                } else {
                    c cVar8 = c.this;
                    cVar8.F(cVar8.p, c.this.f49175c.getCurrentItem() + 1, 1, 31, this.f49187a, this.f49188b);
                }
            } else {
                c cVar9 = c.this;
                cVar9.F(cVar9.p, i3, 1, 31, this.f49187a, this.f49188b);
            }
            if (c.this.x != null) {
                c.this.x.a();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements d.a.m0.b1.o.b.c.b {
        public e() {
        }

        @Override // d.a.m0.b1.o.b.c.b
        public void a(int i2) {
            c.this.x.a();
        }
    }

    public c(View view, boolean[] zArr, int i2, int i3) {
        this.f49173a = view;
        this.f49181i = zArr;
        this.f49180h = i2;
        this.q = i3;
        O(view);
    }

    public void A(float f2) {
        this.u = f2;
        z();
    }

    public final void B(int i2, int i3, int i4, boolean z, int i5, int i6, int i7) {
        WheelView wheelView = (WheelView) this.f49173a.findViewById(R.id.year);
        this.f49174b = wheelView;
        wheelView.setAdapter(new d.a.m0.b1.o.a.a.a(d.a.m0.b1.o.a.e.a.e(this.j, this.k)));
        this.f49174b.setLabel("");
        this.f49174b.setCurrentItem(i2 - this.j);
        this.f49174b.setGravity(this.f49180h);
        WheelView wheelView2 = (WheelView) this.f49173a.findViewById(R.id.month);
        this.f49175c = wheelView2;
        wheelView2.setAdapter(new d.a.m0.b1.o.a.a.a(d.a.m0.b1.o.a.e.a.d(i2)));
        this.f49175c.setLabel("");
        int g2 = d.a.m0.b1.o.a.e.a.g(i2);
        if (g2 != 0 && (i3 > g2 - 1 || z)) {
            this.f49175c.setCurrentItem(i3 + 1);
        } else {
            this.f49175c.setCurrentItem(i3);
        }
        this.f49175c.setGravity(this.f49180h);
        this.f49176d = (WheelView) this.f49173a.findViewById(R.id.day);
        if (d.a.m0.b1.o.a.e.a.g(i2) == 0) {
            this.f49176d.setAdapter(new d.a.m0.b1.o.a.a.a(d.a.m0.b1.o.a.e.a.b(d.a.m0.b1.o.a.e.a.h(i2, i3))));
        } else {
            this.f49176d.setAdapter(new d.a.m0.b1.o.a.a.a(d.a.m0.b1.o.a.e.a.b(d.a.m0.b1.o.a.e.a.f(i2))));
        }
        this.f49176d.setLabel("");
        this.f49176d.setCurrentItem(i4 - 1);
        this.f49176d.setGravity(this.f49180h);
        WheelView wheelView3 = (WheelView) this.f49173a.findViewById(R.id.hour);
        this.f49177e = wheelView3;
        wheelView3.setAdapter(new d.a.m0.b1.o.a.a.b(0, 23));
        this.f49177e.setCurrentItem(i5);
        this.f49177e.setGravity(this.f49180h);
        WheelView wheelView4 = (WheelView) this.f49173a.findViewById(R.id.min);
        this.f49178f = wheelView4;
        wheelView4.setAdapter(new d.a.m0.b1.o.a.a.b(0, 59));
        this.f49178f.setCurrentItem(i6);
        this.f49178f.setGravity(this.f49180h);
        WheelView wheelView5 = (WheelView) this.f49173a.findViewById(R.id.second);
        this.f49179g = wheelView5;
        wheelView5.setAdapter(new d.a.m0.b1.o.a.a.b(0, 59));
        this.f49179g.setCurrentItem(i6);
        this.f49179g.setGravity(this.f49180h);
        this.f49174b.setOnItemSelectedListener(new a());
        this.f49175c.setOnItemSelectedListener(new b());
        q(this.f49176d);
        q(this.f49177e);
        q(this.f49178f);
        q(this.f49179g);
        boolean[] zArr = this.f49181i;
        if (zArr.length == 6) {
            this.f49174b.setVisibility(zArr[0] ? 0 : 8);
            this.f49175c.setVisibility(this.f49181i[1] ? 0 : 8);
            this.f49176d.setVisibility(this.f49181i[2] ? 0 : 8);
            this.f49177e.setVisibility(this.f49181i[3] ? 0 : 8);
            this.f49178f.setVisibility(this.f49181i[4] ? 0 : 8);
            this.f49179g.setVisibility(this.f49181i[5] ? 0 : 8);
            r();
            return;
        }
        throw new RuntimeException("type[] length is not 6");
    }

    public void C(boolean z) {
        this.w = z;
    }

    public void D(int i2, int i3, int i4, int i5, int i6, int i7) {
        if (this.w) {
            int[] d2 = d.a.m0.b1.o.a.e.b.d(i2, i3 + 1, i4);
            B(d2[0], d2[1] - 1, d2[2], d2[3] == 1, i5, i6, i7);
            return;
        }
        H(i2, i3, i4, i5, i6, i7);
    }

    public void E(Calendar calendar, Calendar calendar2) {
        if (calendar == null && calendar2 != null) {
            int i2 = calendar2.get(1);
            int i3 = calendar2.get(2) + 1;
            int i4 = calendar2.get(5);
            int i5 = this.j;
            if (i2 > i5) {
                this.k = i2;
                this.m = i3;
                this.o = i4;
            } else if (i2 == i5) {
                int i6 = this.l;
                if (i3 > i6) {
                    this.k = i2;
                    this.m = i3;
                    this.o = i4;
                } else if (i3 != i6 || i4 <= this.n) {
                } else {
                    this.k = i2;
                    this.m = i3;
                    this.o = i4;
                }
            }
        } else if (calendar == null || calendar2 != null) {
            if (calendar == null || calendar2 == null) {
                return;
            }
            this.j = calendar.get(1);
            this.k = calendar2.get(1);
            this.l = calendar.get(2) + 1;
            this.m = calendar2.get(2) + 1;
            this.n = calendar.get(5);
            this.o = calendar2.get(5);
        } else {
            int i7 = calendar.get(1);
            int i8 = calendar.get(2) + 1;
            int i9 = calendar.get(5);
            int i10 = this.k;
            if (i7 < i10) {
                this.l = i8;
                this.n = i9;
                this.j = i7;
            } else if (i7 == i10) {
                int i11 = this.m;
                if (i8 < i11) {
                    this.l = i8;
                    this.n = i9;
                    this.j = i7;
                } else if (i8 != i11 || i9 >= this.o) {
                } else {
                    this.l = i8;
                    this.n = i9;
                    this.j = i7;
                }
            }
        }
    }

    public final void F(int i2, int i3, int i4, int i5, List<String> list, List<String> list2) {
        int currentItem = this.f49176d.getCurrentItem();
        if (list.contains(String.valueOf(i3))) {
            if (i5 > 31) {
                i5 = 31;
            }
            this.f49176d.setAdapter(new d.a.m0.b1.o.a.a.b(i4, i5));
        } else if (list2.contains(String.valueOf(i3))) {
            if (i5 > 30) {
                i5 = 30;
            }
            this.f49176d.setAdapter(new d.a.m0.b1.o.a.a.b(i4, i5));
        } else if ((i2 % 4 == 0 && i2 % 100 != 0) || i2 % 400 == 0) {
            if (i5 > 29) {
                i5 = 29;
            }
            this.f49176d.setAdapter(new d.a.m0.b1.o.a.a.b(i4, i5));
        } else {
            if (i5 > 28) {
                i5 = 28;
            }
            this.f49176d.setAdapter(new d.a.m0.b1.o.a.a.b(i4, i5));
        }
        if (currentItem > this.f49176d.getAdapter().a() - 1) {
            this.f49176d.setCurrentItem(this.f49176d.getAdapter().a() - 1);
        }
    }

    public void G(d.a.m0.b1.o.a.d.b bVar) {
        this.x = bVar;
    }

    public final void H(int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8;
        int i9;
        String[] strArr = {"1", "3", "5", "7", "8", "10", Constants.VIA_REPORT_TYPE_SET_AVATAR};
        String[] strArr2 = {"4", "6", HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE9, Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE};
        List asList = Arrays.asList(strArr);
        List asList2 = Arrays.asList(strArr2);
        this.p = i2;
        WheelView wheelView = (WheelView) this.f49173a.findViewById(R.id.year);
        this.f49174b = wheelView;
        wheelView.setAdapter(new d.a.m0.b1.o.a.a.b(this.j, this.k));
        this.f49174b.setCurrentItem(i2 - this.j);
        this.f49174b.setGravity(this.f49180h);
        WheelView wheelView2 = (WheelView) this.f49173a.findViewById(R.id.month);
        this.f49175c = wheelView2;
        int i10 = this.j;
        int i11 = this.k;
        if (i10 == i11) {
            wheelView2.setAdapter(new d.a.m0.b1.o.a.a.b(this.l, this.m));
            this.f49175c.setCurrentItem((i3 + 1) - this.l);
        } else if (i2 == i10) {
            wheelView2.setAdapter(new d.a.m0.b1.o.a.a.b(this.l, 12));
            this.f49175c.setCurrentItem((i3 + 1) - this.l);
        } else if (i2 == i11) {
            wheelView2.setAdapter(new d.a.m0.b1.o.a.a.b(1, this.m));
            this.f49175c.setCurrentItem(i3);
        } else {
            wheelView2.setAdapter(new d.a.m0.b1.o.a.a.b(1, 12));
            this.f49175c.setCurrentItem(i3);
        }
        this.f49175c.setGravity(this.f49180h);
        this.f49176d = (WheelView) this.f49173a.findViewById(R.id.day);
        if (this.j == this.k && this.l == this.m) {
            int i12 = i3 + 1;
            if (asList.contains(String.valueOf(i12))) {
                if (this.o > 31) {
                    this.o = 31;
                }
                this.f49176d.setAdapter(new d.a.m0.b1.o.a.a.b(this.n, this.o));
            } else if (asList2.contains(String.valueOf(i12))) {
                if (this.o > 30) {
                    this.o = 30;
                }
                this.f49176d.setAdapter(new d.a.m0.b1.o.a.a.b(this.n, this.o));
            } else if ((i2 % 4 == 0 && i2 % 100 != 0) || i2 % 400 == 0) {
                if (this.o > 29) {
                    this.o = 29;
                }
                this.f49176d.setAdapter(new d.a.m0.b1.o.a.a.b(this.n, this.o));
            } else {
                if (this.o > 28) {
                    this.o = 28;
                }
                this.f49176d.setAdapter(new d.a.m0.b1.o.a.a.b(this.n, this.o));
            }
            this.f49176d.setCurrentItem(i4 - this.n);
        } else if (i2 == this.j && (i9 = i3 + 1) == this.l) {
            if (asList.contains(String.valueOf(i9))) {
                this.f49176d.setAdapter(new d.a.m0.b1.o.a.a.b(this.n, 31));
            } else if (asList2.contains(String.valueOf(i9))) {
                this.f49176d.setAdapter(new d.a.m0.b1.o.a.a.b(this.n, 30));
            } else if ((i2 % 4 == 0 && i2 % 100 != 0) || i2 % 400 == 0) {
                this.f49176d.setAdapter(new d.a.m0.b1.o.a.a.b(this.n, 29));
            } else {
                this.f49176d.setAdapter(new d.a.m0.b1.o.a.a.b(this.n, 28));
            }
            this.f49176d.setCurrentItem(i4 - this.n);
        } else if (i2 == this.k && (i8 = i3 + 1) == this.m) {
            if (asList.contains(String.valueOf(i8))) {
                if (this.o > 31) {
                    this.o = 31;
                }
                this.f49176d.setAdapter(new d.a.m0.b1.o.a.a.b(1, this.o));
            } else if (asList2.contains(String.valueOf(i8))) {
                if (this.o > 30) {
                    this.o = 30;
                }
                this.f49176d.setAdapter(new d.a.m0.b1.o.a.a.b(1, this.o));
            } else if ((i2 % 4 == 0 && i2 % 100 != 0) || i2 % 400 == 0) {
                if (this.o > 29) {
                    this.o = 29;
                }
                this.f49176d.setAdapter(new d.a.m0.b1.o.a.a.b(1, this.o));
            } else {
                if (this.o > 28) {
                    this.o = 28;
                }
                this.f49176d.setAdapter(new d.a.m0.b1.o.a.a.b(1, this.o));
            }
            this.f49176d.setCurrentItem(i4 - 1);
        } else {
            int i13 = i3 + 1;
            if (asList.contains(String.valueOf(i13))) {
                this.f49176d.setAdapter(new d.a.m0.b1.o.a.a.b(1, 31));
            } else if (asList2.contains(String.valueOf(i13))) {
                this.f49176d.setAdapter(new d.a.m0.b1.o.a.a.b(1, 30));
            } else if ((i2 % 4 == 0 && i2 % 100 != 0) || i2 % 400 == 0) {
                this.f49176d.setAdapter(new d.a.m0.b1.o.a.a.b(1, 29));
            } else {
                this.f49176d.setAdapter(new d.a.m0.b1.o.a.a.b(1, 28));
            }
            this.f49176d.setCurrentItem(i4 - 1);
        }
        this.f49176d.setGravity(this.f49180h);
        WheelView wheelView3 = (WheelView) this.f49173a.findViewById(R.id.hour);
        this.f49177e = wheelView3;
        wheelView3.setAdapter(new d.a.m0.b1.o.a.a.b(0, 23));
        this.f49177e.setCurrentItem(i5);
        this.f49177e.setGravity(this.f49180h);
        WheelView wheelView4 = (WheelView) this.f49173a.findViewById(R.id.min);
        this.f49178f = wheelView4;
        wheelView4.setAdapter(new d.a.m0.b1.o.a.a.b(0, 59));
        this.f49178f.setCurrentItem(i6);
        this.f49178f.setGravity(this.f49180h);
        WheelView wheelView5 = (WheelView) this.f49173a.findViewById(R.id.second);
        this.f49179g = wheelView5;
        wheelView5.setAdapter(new d.a.m0.b1.o.a.a.b(0, 59));
        this.f49179g.setCurrentItem(i7);
        this.f49179g.setGravity(this.f49180h);
        this.f49174b.setOnItemSelectedListener(new C1114c(asList, asList2));
        this.f49175c.setOnItemSelectedListener(new d(asList, asList2));
        q(this.f49176d);
        q(this.f49177e);
        q(this.f49178f);
        q(this.f49179g);
        boolean[] zArr = this.f49181i;
        if (zArr.length == 6) {
            this.f49174b.setVisibility(zArr[0] ? 0 : 8);
            this.f49175c.setVisibility(this.f49181i[1] ? 0 : 8);
            this.f49176d.setVisibility(this.f49181i[2] ? 0 : 8);
            this.f49177e.setVisibility(this.f49181i[3] ? 0 : 8);
            this.f49178f.setVisibility(this.f49181i[4] ? 0 : 8);
            this.f49179g.setVisibility(this.f49181i[5] ? 0 : 8);
            r();
            return;
        }
        throw new IllegalArgumentException("type[] length is not 6");
    }

    public void I(int i2) {
        this.j = i2;
    }

    public final void J() {
        this.f49176d.setTextColorCenter(this.s);
        this.f49175c.setTextColorCenter(this.s);
        this.f49174b.setTextColorCenter(this.s);
        this.f49177e.setTextColorCenter(this.s);
        this.f49178f.setTextColorCenter(this.s);
        this.f49179g.setTextColorCenter(this.s);
    }

    public void K(int i2) {
        this.s = i2;
        J();
    }

    public final void L() {
        this.f49176d.setTextColorOut(this.r);
        this.f49175c.setTextColorOut(this.r);
        this.f49174b.setTextColorOut(this.r);
        this.f49177e.setTextColorOut(this.r);
        this.f49178f.setTextColorOut(this.r);
        this.f49179g.setTextColorOut(this.r);
    }

    public void M(int i2) {
        this.r = i2;
        L();
    }

    public void N(int i2, int i3, int i4, int i5, int i6, int i7) {
        this.f49176d.setTextXOffset(i2);
        this.f49175c.setTextXOffset(i3);
        this.f49174b.setTextXOffset(i4);
        this.f49177e.setTextXOffset(i5);
        this.f49178f.setTextXOffset(i6);
        this.f49179g.setTextXOffset(i7);
    }

    public void O(View view) {
        this.f49173a = view;
    }

    public final String n() {
        int currentItem;
        boolean z;
        int currentItem2;
        StringBuilder sb = new StringBuilder();
        int currentItem3 = this.f49174b.getCurrentItem() + this.j;
        if (d.a.m0.b1.o.a.e.a.g(currentItem3) == 0) {
            currentItem2 = this.f49175c.getCurrentItem();
        } else if ((this.f49175c.getCurrentItem() + 1) - d.a.m0.b1.o.a.e.a.g(currentItem3) <= 0) {
            currentItem2 = this.f49175c.getCurrentItem();
        } else if ((this.f49175c.getCurrentItem() + 1) - d.a.m0.b1.o.a.e.a.g(currentItem3) == 1) {
            currentItem = this.f49175c.getCurrentItem();
            z = true;
            int[] b2 = d.a.m0.b1.o.a.e.b.b(currentItem3, currentItem, this.f49176d.getCurrentItem() + 1, z);
            sb.append(b2[0]);
            sb.append("-");
            sb.append(b2[1]);
            sb.append("-");
            sb.append(b2[2]);
            sb.append(" ");
            sb.append(this.f49177e.getCurrentItem());
            sb.append(":");
            sb.append(this.f49178f.getCurrentItem());
            sb.append(":");
            sb.append(this.f49179g.getCurrentItem());
            return sb.toString();
        } else {
            currentItem = this.f49175c.getCurrentItem();
            z = false;
            int[] b22 = d.a.m0.b1.o.a.e.b.b(currentItem3, currentItem, this.f49176d.getCurrentItem() + 1, z);
            sb.append(b22[0]);
            sb.append("-");
            sb.append(b22[1]);
            sb.append("-");
            sb.append(b22[2]);
            sb.append(" ");
            sb.append(this.f49177e.getCurrentItem());
            sb.append(":");
            sb.append(this.f49178f.getCurrentItem());
            sb.append(":");
            sb.append(this.f49179g.getCurrentItem());
            return sb.toString();
        }
        currentItem = currentItem2 + 1;
        z = false;
        int[] b222 = d.a.m0.b1.o.a.e.b.b(currentItem3, currentItem, this.f49176d.getCurrentItem() + 1, z);
        sb.append(b222[0]);
        sb.append("-");
        sb.append(b222[1]);
        sb.append("-");
        sb.append(b222[2]);
        sb.append(" ");
        sb.append(this.f49177e.getCurrentItem());
        sb.append(":");
        sb.append(this.f49178f.getCurrentItem());
        sb.append(":");
        sb.append(this.f49179g.getCurrentItem());
        return sb.toString();
    }

    public String o() {
        if (this.w) {
            return n();
        }
        StringBuilder sb = new StringBuilder();
        if (this.p == this.j) {
            int currentItem = this.f49175c.getCurrentItem();
            int i2 = this.l;
            if (currentItem + i2 == i2) {
                sb.append(this.f49174b.getCurrentItem() + this.j);
                sb.append("-");
                sb.append(this.f49175c.getCurrentItem() + this.l);
                sb.append("-");
                sb.append(this.f49176d.getCurrentItem() + this.n);
                sb.append(" ");
                sb.append(this.f49177e.getCurrentItem());
                sb.append(":");
                sb.append(this.f49178f.getCurrentItem());
                sb.append(":");
                sb.append(this.f49179g.getCurrentItem());
            } else {
                sb.append(this.f49174b.getCurrentItem() + this.j);
                sb.append("-");
                sb.append(this.f49175c.getCurrentItem() + this.l);
                sb.append("-");
                sb.append(this.f49176d.getCurrentItem() + 1);
                sb.append(" ");
                sb.append(this.f49177e.getCurrentItem());
                sb.append(":");
                sb.append(this.f49178f.getCurrentItem());
                sb.append(":");
                sb.append(this.f49179g.getCurrentItem());
            }
        } else {
            sb.append(this.f49174b.getCurrentItem() + this.j);
            sb.append("-");
            sb.append(this.f49175c.getCurrentItem() + 1);
            sb.append("-");
            sb.append(this.f49176d.getCurrentItem() + 1);
            sb.append(" ");
            sb.append(this.f49177e.getCurrentItem());
            sb.append(":");
            sb.append(this.f49178f.getCurrentItem());
            sb.append(":");
            sb.append(this.f49179g.getCurrentItem());
        }
        return sb.toString();
    }

    public void p(boolean z) {
        this.f49176d.h(z);
        this.f49175c.h(z);
        this.f49174b.h(z);
        this.f49177e.h(z);
        this.f49178f.h(z);
        this.f49179g.h(z);
    }

    public final void q(WheelView wheelView) {
        if (this.x != null) {
            wheelView.setOnItemSelectedListener(new e());
        }
    }

    public final void r() {
        this.f49176d.setTextSize(this.q);
        this.f49175c.setTextSize(this.q);
        this.f49174b.setTextSize(this.q);
        this.f49177e.setTextSize(this.q);
        this.f49178f.setTextSize(this.q);
        this.f49179g.setTextSize(this.q);
    }

    public void s(boolean z) {
        this.f49174b.setCyclic(z);
        this.f49175c.setCyclic(z);
        this.f49176d.setCyclic(z);
        this.f49177e.setCyclic(z);
        this.f49178f.setCyclic(z);
        this.f49179g.setCyclic(z);
    }

    public final void t() {
        this.f49176d.setDividerColor(this.t);
        this.f49175c.setDividerColor(this.t);
        this.f49174b.setDividerColor(this.t);
        this.f49177e.setDividerColor(this.t);
        this.f49178f.setDividerColor(this.t);
        this.f49179g.setDividerColor(this.t);
    }

    public void u(int i2) {
        this.t = i2;
        t();
    }

    public final void v() {
        this.f49176d.setDividerType(this.v);
        this.f49175c.setDividerType(this.v);
        this.f49174b.setDividerType(this.v);
        this.f49177e.setDividerType(this.v);
        this.f49178f.setDividerType(this.v);
        this.f49179g.setDividerType(this.v);
    }

    public void w(WheelView.DividerType dividerType) {
        this.v = dividerType;
        v();
    }

    public void x(int i2) {
        this.k = i2;
    }

    public void y(String str, String str2, String str3, String str4, String str5, String str6) {
        if (this.w) {
            return;
        }
        if (str != null) {
            this.f49174b.setLabel(str);
        } else {
            this.f49174b.setLabel(this.f49173a.getContext().getString(R.string.pickerview_year));
        }
        if (str2 != null) {
            this.f49175c.setLabel(str2);
        } else {
            this.f49175c.setLabel(this.f49173a.getContext().getString(R.string.pickerview_month));
        }
        if (str3 != null) {
            this.f49176d.setLabel(str3);
        } else {
            this.f49176d.setLabel(this.f49173a.getContext().getString(R.string.pickerview_day));
        }
        if (str4 != null) {
            this.f49177e.setLabel(str4);
        } else {
            this.f49177e.setLabel(this.f49173a.getContext().getString(R.string.pickerview_hours));
        }
        if (str5 != null) {
            this.f49178f.setLabel(str5);
        } else {
            this.f49178f.setLabel(this.f49173a.getContext().getString(R.string.pickerview_minutes));
        }
        if (str6 != null) {
            this.f49179g.setLabel(str6);
        } else {
            this.f49179g.setLabel(this.f49173a.getContext().getString(R.string.pickerview_seconds));
        }
    }

    public final void z() {
        this.f49176d.setLineSpacingMultiplier(this.u);
        this.f49175c.setLineSpacingMultiplier(this.u);
        this.f49174b.setLineSpacingMultiplier(this.u);
        this.f49177e.setLineSpacingMultiplier(this.u);
        this.f49178f.setLineSpacingMultiplier(this.u);
        this.f49179g.setLineSpacingMultiplier(this.u);
    }
}
