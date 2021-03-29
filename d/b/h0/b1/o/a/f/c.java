package d.b.h0.b1.o.a.f;

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
    public View f50021a;

    /* renamed from: b  reason: collision with root package name */
    public WheelView f50022b;

    /* renamed from: c  reason: collision with root package name */
    public WheelView f50023c;

    /* renamed from: d  reason: collision with root package name */
    public WheelView f50024d;

    /* renamed from: e  reason: collision with root package name */
    public WheelView f50025e;

    /* renamed from: f  reason: collision with root package name */
    public WheelView f50026f;

    /* renamed from: g  reason: collision with root package name */
    public WheelView f50027g;

    /* renamed from: h  reason: collision with root package name */
    public int f50028h;
    public boolean[] i;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public float u;
    public WheelView.DividerType v;
    public d.b.h0.b1.o.a.d.b x;
    public int j = 1900;
    public int k = 2100;
    public int l = 1;
    public int m = 12;
    public int n = 1;
    public int o = 31;
    public boolean w = false;

    /* loaded from: classes3.dex */
    public class a implements d.b.h0.b1.o.b.c.b {
        public a() {
        }

        @Override // d.b.h0.b1.o.b.c.b
        public void a(int i) {
            int h2;
            int i2 = i + c.this.j;
            c.this.f50023c.setAdapter(new d.b.h0.b1.o.a.a.a(d.b.h0.b1.o.a.e.a.d(i2)));
            if (d.b.h0.b1.o.a.e.a.g(i2) == 0 || c.this.f50023c.getCurrentItem() <= d.b.h0.b1.o.a.e.a.g(i2) - 1) {
                c.this.f50023c.setCurrentItem(c.this.f50023c.getCurrentItem());
            } else {
                c.this.f50023c.setCurrentItem(c.this.f50023c.getCurrentItem() + 1);
            }
            if (d.b.h0.b1.o.a.e.a.g(i2) == 0 || c.this.f50023c.getCurrentItem() <= d.b.h0.b1.o.a.e.a.g(i2) - 1) {
                c.this.f50024d.setAdapter(new d.b.h0.b1.o.a.a.a(d.b.h0.b1.o.a.e.a.b(d.b.h0.b1.o.a.e.a.h(i2, c.this.f50023c.getCurrentItem() + 1))));
                h2 = d.b.h0.b1.o.a.e.a.h(i2, c.this.f50023c.getCurrentItem() + 1);
            } else if (c.this.f50023c.getCurrentItem() == d.b.h0.b1.o.a.e.a.g(i2) + 1) {
                c.this.f50024d.setAdapter(new d.b.h0.b1.o.a.a.a(d.b.h0.b1.o.a.e.a.b(d.b.h0.b1.o.a.e.a.f(i2))));
                h2 = d.b.h0.b1.o.a.e.a.f(i2);
            } else {
                c.this.f50024d.setAdapter(new d.b.h0.b1.o.a.a.a(d.b.h0.b1.o.a.e.a.b(d.b.h0.b1.o.a.e.a.h(i2, c.this.f50023c.getCurrentItem()))));
                h2 = d.b.h0.b1.o.a.e.a.h(i2, c.this.f50023c.getCurrentItem());
            }
            int i3 = h2 - 1;
            if (c.this.f50024d.getCurrentItem() > i3) {
                c.this.f50024d.setCurrentItem(i3);
            }
            if (c.this.x != null) {
                c.this.x.a();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.b.h0.b1.o.b.c.b {
        public b() {
        }

        @Override // d.b.h0.b1.o.b.c.b
        public void a(int i) {
            int h2;
            int currentItem = c.this.f50022b.getCurrentItem() + c.this.j;
            if (d.b.h0.b1.o.a.e.a.g(currentItem) == 0 || i <= d.b.h0.b1.o.a.e.a.g(currentItem) - 1) {
                int i2 = i + 1;
                c.this.f50024d.setAdapter(new d.b.h0.b1.o.a.a.a(d.b.h0.b1.o.a.e.a.b(d.b.h0.b1.o.a.e.a.h(currentItem, i2))));
                h2 = d.b.h0.b1.o.a.e.a.h(currentItem, i2);
            } else if (c.this.f50023c.getCurrentItem() == d.b.h0.b1.o.a.e.a.g(currentItem) + 1) {
                c.this.f50024d.setAdapter(new d.b.h0.b1.o.a.a.a(d.b.h0.b1.o.a.e.a.b(d.b.h0.b1.o.a.e.a.f(currentItem))));
                h2 = d.b.h0.b1.o.a.e.a.f(currentItem);
            } else {
                c.this.f50024d.setAdapter(new d.b.h0.b1.o.a.a.a(d.b.h0.b1.o.a.e.a.b(d.b.h0.b1.o.a.e.a.h(currentItem, i))));
                h2 = d.b.h0.b1.o.a.e.a.h(currentItem, i);
            }
            int i3 = h2 - 1;
            if (c.this.f50024d.getCurrentItem() > i3) {
                c.this.f50024d.setCurrentItem(i3);
            }
            if (c.this.x != null) {
                c.this.x.a();
            }
        }
    }

    /* renamed from: d.b.h0.b1.o.a.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1058c implements d.b.h0.b1.o.b.c.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f50031a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f50032b;

        public C1058c(List list, List list2) {
            this.f50031a = list;
            this.f50032b = list2;
        }

        @Override // d.b.h0.b1.o.b.c.b
        public void a(int i) {
            int i2 = i + c.this.j;
            c.this.p = i2;
            int currentItem = c.this.f50023c.getCurrentItem();
            if (c.this.j == c.this.k) {
                c.this.f50023c.setAdapter(new d.b.h0.b1.o.a.a.b(c.this.l, c.this.m));
                if (currentItem > c.this.f50023c.getAdapter().a() - 1) {
                    currentItem = c.this.f50023c.getAdapter().a() - 1;
                    c.this.f50023c.setCurrentItem(currentItem);
                }
                int i3 = currentItem + c.this.l;
                if (c.this.l != c.this.m) {
                    if (i3 != c.this.l) {
                        if (i3 != c.this.m) {
                            c.this.F(i2, i3, 1, 31, this.f50031a, this.f50032b);
                        } else {
                            c cVar = c.this;
                            cVar.F(i2, i3, 1, cVar.o, this.f50031a, this.f50032b);
                        }
                    } else {
                        c cVar2 = c.this;
                        cVar2.F(i2, i3, cVar2.n, 31, this.f50031a, this.f50032b);
                    }
                } else {
                    c cVar3 = c.this;
                    cVar3.F(i2, i3, cVar3.n, c.this.o, this.f50031a, this.f50032b);
                }
            } else if (i2 == c.this.j) {
                c.this.f50023c.setAdapter(new d.b.h0.b1.o.a.a.b(c.this.l, 12));
                if (currentItem > c.this.f50023c.getAdapter().a() - 1) {
                    currentItem = c.this.f50023c.getAdapter().a() - 1;
                    c.this.f50023c.setCurrentItem(currentItem);
                }
                int i4 = currentItem + c.this.l;
                if (i4 != c.this.l) {
                    c.this.F(i2, i4, 1, 31, this.f50031a, this.f50032b);
                } else {
                    c cVar4 = c.this;
                    cVar4.F(i2, i4, cVar4.n, 31, this.f50031a, this.f50032b);
                }
            } else if (i2 == c.this.k) {
                c.this.f50023c.setAdapter(new d.b.h0.b1.o.a.a.b(1, c.this.m));
                if (currentItem > c.this.f50023c.getAdapter().a() - 1) {
                    currentItem = c.this.f50023c.getAdapter().a() - 1;
                    c.this.f50023c.setCurrentItem(currentItem);
                }
                int i5 = 1 + currentItem;
                if (i5 != c.this.m) {
                    c.this.F(i2, i5, 1, 31, this.f50031a, this.f50032b);
                } else {
                    c cVar5 = c.this;
                    cVar5.F(i2, i5, 1, cVar5.o, this.f50031a, this.f50032b);
                }
            } else {
                c.this.f50023c.setAdapter(new d.b.h0.b1.o.a.a.b(1, 12));
                c cVar6 = c.this;
                cVar6.F(i2, 1 + cVar6.f50023c.getCurrentItem(), 1, 31, this.f50031a, this.f50032b);
            }
            if (c.this.x != null) {
                c.this.x.a();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements d.b.h0.b1.o.b.c.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f50034a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f50035b;

        public d(List list, List list2) {
            this.f50034a = list;
            this.f50035b = list2;
        }

        @Override // d.b.h0.b1.o.b.c.b
        public void a(int i) {
            int i2 = i + 1;
            if (c.this.j == c.this.k) {
                int i3 = (i2 + c.this.l) - 1;
                if (c.this.l != c.this.m) {
                    if (c.this.l != i3) {
                        if (c.this.m == i3) {
                            c cVar = c.this;
                            cVar.F(cVar.p, i3, 1, c.this.o, this.f50034a, this.f50035b);
                        } else {
                            c cVar2 = c.this;
                            cVar2.F(cVar2.p, i3, 1, 31, this.f50034a, this.f50035b);
                        }
                    } else {
                        c cVar3 = c.this;
                        cVar3.F(cVar3.p, i3, c.this.n, 31, this.f50034a, this.f50035b);
                    }
                } else {
                    c cVar4 = c.this;
                    cVar4.F(cVar4.p, i3, c.this.n, c.this.o, this.f50034a, this.f50035b);
                }
            } else if (c.this.p == c.this.j) {
                int i4 = (i2 + c.this.l) - 1;
                if (i4 == c.this.l) {
                    c cVar5 = c.this;
                    cVar5.F(cVar5.p, i4, c.this.n, 31, this.f50034a, this.f50035b);
                } else {
                    c cVar6 = c.this;
                    cVar6.F(cVar6.p, i4, 1, 31, this.f50034a, this.f50035b);
                }
            } else if (c.this.p == c.this.k) {
                if (i2 == c.this.m) {
                    c cVar7 = c.this;
                    cVar7.F(cVar7.p, c.this.f50023c.getCurrentItem() + 1, 1, c.this.o, this.f50034a, this.f50035b);
                } else {
                    c cVar8 = c.this;
                    cVar8.F(cVar8.p, c.this.f50023c.getCurrentItem() + 1, 1, 31, this.f50034a, this.f50035b);
                }
            } else {
                c cVar9 = c.this;
                cVar9.F(cVar9.p, i2, 1, 31, this.f50034a, this.f50035b);
            }
            if (c.this.x != null) {
                c.this.x.a();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements d.b.h0.b1.o.b.c.b {
        public e() {
        }

        @Override // d.b.h0.b1.o.b.c.b
        public void a(int i) {
            c.this.x.a();
        }
    }

    public c(View view, boolean[] zArr, int i, int i2) {
        this.f50021a = view;
        this.i = zArr;
        this.f50028h = i;
        this.q = i2;
        O(view);
    }

    public void A(float f2) {
        this.u = f2;
        z();
    }

    public final void B(int i, int i2, int i3, boolean z, int i4, int i5, int i6) {
        WheelView wheelView = (WheelView) this.f50021a.findViewById(R.id.year);
        this.f50022b = wheelView;
        wheelView.setAdapter(new d.b.h0.b1.o.a.a.a(d.b.h0.b1.o.a.e.a.e(this.j, this.k)));
        this.f50022b.setLabel("");
        this.f50022b.setCurrentItem(i - this.j);
        this.f50022b.setGravity(this.f50028h);
        WheelView wheelView2 = (WheelView) this.f50021a.findViewById(R.id.month);
        this.f50023c = wheelView2;
        wheelView2.setAdapter(new d.b.h0.b1.o.a.a.a(d.b.h0.b1.o.a.e.a.d(i)));
        this.f50023c.setLabel("");
        int g2 = d.b.h0.b1.o.a.e.a.g(i);
        if (g2 != 0 && (i2 > g2 - 1 || z)) {
            this.f50023c.setCurrentItem(i2 + 1);
        } else {
            this.f50023c.setCurrentItem(i2);
        }
        this.f50023c.setGravity(this.f50028h);
        this.f50024d = (WheelView) this.f50021a.findViewById(R.id.day);
        if (d.b.h0.b1.o.a.e.a.g(i) == 0) {
            this.f50024d.setAdapter(new d.b.h0.b1.o.a.a.a(d.b.h0.b1.o.a.e.a.b(d.b.h0.b1.o.a.e.a.h(i, i2))));
        } else {
            this.f50024d.setAdapter(new d.b.h0.b1.o.a.a.a(d.b.h0.b1.o.a.e.a.b(d.b.h0.b1.o.a.e.a.f(i))));
        }
        this.f50024d.setLabel("");
        this.f50024d.setCurrentItem(i3 - 1);
        this.f50024d.setGravity(this.f50028h);
        WheelView wheelView3 = (WheelView) this.f50021a.findViewById(R.id.hour);
        this.f50025e = wheelView3;
        wheelView3.setAdapter(new d.b.h0.b1.o.a.a.b(0, 23));
        this.f50025e.setCurrentItem(i4);
        this.f50025e.setGravity(this.f50028h);
        WheelView wheelView4 = (WheelView) this.f50021a.findViewById(R.id.min);
        this.f50026f = wheelView4;
        wheelView4.setAdapter(new d.b.h0.b1.o.a.a.b(0, 59));
        this.f50026f.setCurrentItem(i5);
        this.f50026f.setGravity(this.f50028h);
        WheelView wheelView5 = (WheelView) this.f50021a.findViewById(R.id.second);
        this.f50027g = wheelView5;
        wheelView5.setAdapter(new d.b.h0.b1.o.a.a.b(0, 59));
        this.f50027g.setCurrentItem(i5);
        this.f50027g.setGravity(this.f50028h);
        this.f50022b.setOnItemSelectedListener(new a());
        this.f50023c.setOnItemSelectedListener(new b());
        q(this.f50024d);
        q(this.f50025e);
        q(this.f50026f);
        q(this.f50027g);
        boolean[] zArr = this.i;
        if (zArr.length == 6) {
            this.f50022b.setVisibility(zArr[0] ? 0 : 8);
            this.f50023c.setVisibility(this.i[1] ? 0 : 8);
            this.f50024d.setVisibility(this.i[2] ? 0 : 8);
            this.f50025e.setVisibility(this.i[3] ? 0 : 8);
            this.f50026f.setVisibility(this.i[4] ? 0 : 8);
            this.f50027g.setVisibility(this.i[5] ? 0 : 8);
            r();
            return;
        }
        throw new RuntimeException("type[] length is not 6");
    }

    public void C(boolean z) {
        this.w = z;
    }

    public void D(int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.w) {
            int[] d2 = d.b.h0.b1.o.a.e.b.d(i, i2 + 1, i3);
            B(d2[0], d2[1] - 1, d2[2], d2[3] == 1, i4, i5, i6);
            return;
        }
        H(i, i2, i3, i4, i5, i6);
    }

    public void E(Calendar calendar, Calendar calendar2) {
        if (calendar == null && calendar2 != null) {
            int i = calendar2.get(1);
            int i2 = calendar2.get(2) + 1;
            int i3 = calendar2.get(5);
            int i4 = this.j;
            if (i > i4) {
                this.k = i;
                this.m = i2;
                this.o = i3;
            } else if (i == i4) {
                int i5 = this.l;
                if (i2 > i5) {
                    this.k = i;
                    this.m = i2;
                    this.o = i3;
                } else if (i2 != i5 || i3 <= this.n) {
                } else {
                    this.k = i;
                    this.m = i2;
                    this.o = i3;
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
            int i6 = calendar.get(1);
            int i7 = calendar.get(2) + 1;
            int i8 = calendar.get(5);
            int i9 = this.k;
            if (i6 < i9) {
                this.l = i7;
                this.n = i8;
                this.j = i6;
            } else if (i6 == i9) {
                int i10 = this.m;
                if (i7 < i10) {
                    this.l = i7;
                    this.n = i8;
                    this.j = i6;
                } else if (i7 != i10 || i8 >= this.o) {
                } else {
                    this.l = i7;
                    this.n = i8;
                    this.j = i6;
                }
            }
        }
    }

    public final void F(int i, int i2, int i3, int i4, List<String> list, List<String> list2) {
        int currentItem = this.f50024d.getCurrentItem();
        if (list.contains(String.valueOf(i2))) {
            if (i4 > 31) {
                i4 = 31;
            }
            this.f50024d.setAdapter(new d.b.h0.b1.o.a.a.b(i3, i4));
        } else if (list2.contains(String.valueOf(i2))) {
            if (i4 > 30) {
                i4 = 30;
            }
            this.f50024d.setAdapter(new d.b.h0.b1.o.a.a.b(i3, i4));
        } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
            if (i4 > 29) {
                i4 = 29;
            }
            this.f50024d.setAdapter(new d.b.h0.b1.o.a.a.b(i3, i4));
        } else {
            if (i4 > 28) {
                i4 = 28;
            }
            this.f50024d.setAdapter(new d.b.h0.b1.o.a.a.b(i3, i4));
        }
        if (currentItem > this.f50024d.getAdapter().a() - 1) {
            this.f50024d.setCurrentItem(this.f50024d.getAdapter().a() - 1);
        }
    }

    public void G(d.b.h0.b1.o.a.d.b bVar) {
        this.x = bVar;
    }

    public final void H(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        String[] strArr = {"1", "3", "5", "7", "8", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, Constants.VIA_REPORT_TYPE_SET_AVATAR};
        String[] strArr2 = {"4", "6", HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE9, Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE};
        List asList = Arrays.asList(strArr);
        List asList2 = Arrays.asList(strArr2);
        this.p = i;
        WheelView wheelView = (WheelView) this.f50021a.findViewById(R.id.year);
        this.f50022b = wheelView;
        wheelView.setAdapter(new d.b.h0.b1.o.a.a.b(this.j, this.k));
        this.f50022b.setCurrentItem(i - this.j);
        this.f50022b.setGravity(this.f50028h);
        WheelView wheelView2 = (WheelView) this.f50021a.findViewById(R.id.month);
        this.f50023c = wheelView2;
        int i9 = this.j;
        int i10 = this.k;
        if (i9 == i10) {
            wheelView2.setAdapter(new d.b.h0.b1.o.a.a.b(this.l, this.m));
            this.f50023c.setCurrentItem((i2 + 1) - this.l);
        } else if (i == i9) {
            wheelView2.setAdapter(new d.b.h0.b1.o.a.a.b(this.l, 12));
            this.f50023c.setCurrentItem((i2 + 1) - this.l);
        } else if (i == i10) {
            wheelView2.setAdapter(new d.b.h0.b1.o.a.a.b(1, this.m));
            this.f50023c.setCurrentItem(i2);
        } else {
            wheelView2.setAdapter(new d.b.h0.b1.o.a.a.b(1, 12));
            this.f50023c.setCurrentItem(i2);
        }
        this.f50023c.setGravity(this.f50028h);
        this.f50024d = (WheelView) this.f50021a.findViewById(R.id.day);
        if (this.j == this.k && this.l == this.m) {
            int i11 = i2 + 1;
            if (asList.contains(String.valueOf(i11))) {
                if (this.o > 31) {
                    this.o = 31;
                }
                this.f50024d.setAdapter(new d.b.h0.b1.o.a.a.b(this.n, this.o));
            } else if (asList2.contains(String.valueOf(i11))) {
                if (this.o > 30) {
                    this.o = 30;
                }
                this.f50024d.setAdapter(new d.b.h0.b1.o.a.a.b(this.n, this.o));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.o > 29) {
                    this.o = 29;
                }
                this.f50024d.setAdapter(new d.b.h0.b1.o.a.a.b(this.n, this.o));
            } else {
                if (this.o > 28) {
                    this.o = 28;
                }
                this.f50024d.setAdapter(new d.b.h0.b1.o.a.a.b(this.n, this.o));
            }
            this.f50024d.setCurrentItem(i3 - this.n);
        } else if (i == this.j && (i8 = i2 + 1) == this.l) {
            if (asList.contains(String.valueOf(i8))) {
                this.f50024d.setAdapter(new d.b.h0.b1.o.a.a.b(this.n, 31));
            } else if (asList2.contains(String.valueOf(i8))) {
                this.f50024d.setAdapter(new d.b.h0.b1.o.a.a.b(this.n, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.f50024d.setAdapter(new d.b.h0.b1.o.a.a.b(this.n, 29));
            } else {
                this.f50024d.setAdapter(new d.b.h0.b1.o.a.a.b(this.n, 28));
            }
            this.f50024d.setCurrentItem(i3 - this.n);
        } else if (i == this.k && (i7 = i2 + 1) == this.m) {
            if (asList.contains(String.valueOf(i7))) {
                if (this.o > 31) {
                    this.o = 31;
                }
                this.f50024d.setAdapter(new d.b.h0.b1.o.a.a.b(1, this.o));
            } else if (asList2.contains(String.valueOf(i7))) {
                if (this.o > 30) {
                    this.o = 30;
                }
                this.f50024d.setAdapter(new d.b.h0.b1.o.a.a.b(1, this.o));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.o > 29) {
                    this.o = 29;
                }
                this.f50024d.setAdapter(new d.b.h0.b1.o.a.a.b(1, this.o));
            } else {
                if (this.o > 28) {
                    this.o = 28;
                }
                this.f50024d.setAdapter(new d.b.h0.b1.o.a.a.b(1, this.o));
            }
            this.f50024d.setCurrentItem(i3 - 1);
        } else {
            int i12 = i2 + 1;
            if (asList.contains(String.valueOf(i12))) {
                this.f50024d.setAdapter(new d.b.h0.b1.o.a.a.b(1, 31));
            } else if (asList2.contains(String.valueOf(i12))) {
                this.f50024d.setAdapter(new d.b.h0.b1.o.a.a.b(1, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.f50024d.setAdapter(new d.b.h0.b1.o.a.a.b(1, 29));
            } else {
                this.f50024d.setAdapter(new d.b.h0.b1.o.a.a.b(1, 28));
            }
            this.f50024d.setCurrentItem(i3 - 1);
        }
        this.f50024d.setGravity(this.f50028h);
        WheelView wheelView3 = (WheelView) this.f50021a.findViewById(R.id.hour);
        this.f50025e = wheelView3;
        wheelView3.setAdapter(new d.b.h0.b1.o.a.a.b(0, 23));
        this.f50025e.setCurrentItem(i4);
        this.f50025e.setGravity(this.f50028h);
        WheelView wheelView4 = (WheelView) this.f50021a.findViewById(R.id.min);
        this.f50026f = wheelView4;
        wheelView4.setAdapter(new d.b.h0.b1.o.a.a.b(0, 59));
        this.f50026f.setCurrentItem(i5);
        this.f50026f.setGravity(this.f50028h);
        WheelView wheelView5 = (WheelView) this.f50021a.findViewById(R.id.second);
        this.f50027g = wheelView5;
        wheelView5.setAdapter(new d.b.h0.b1.o.a.a.b(0, 59));
        this.f50027g.setCurrentItem(i6);
        this.f50027g.setGravity(this.f50028h);
        this.f50022b.setOnItemSelectedListener(new C1058c(asList, asList2));
        this.f50023c.setOnItemSelectedListener(new d(asList, asList2));
        q(this.f50024d);
        q(this.f50025e);
        q(this.f50026f);
        q(this.f50027g);
        boolean[] zArr = this.i;
        if (zArr.length == 6) {
            this.f50022b.setVisibility(zArr[0] ? 0 : 8);
            this.f50023c.setVisibility(this.i[1] ? 0 : 8);
            this.f50024d.setVisibility(this.i[2] ? 0 : 8);
            this.f50025e.setVisibility(this.i[3] ? 0 : 8);
            this.f50026f.setVisibility(this.i[4] ? 0 : 8);
            this.f50027g.setVisibility(this.i[5] ? 0 : 8);
            r();
            return;
        }
        throw new IllegalArgumentException("type[] length is not 6");
    }

    public void I(int i) {
        this.j = i;
    }

    public final void J() {
        this.f50024d.setTextColorCenter(this.s);
        this.f50023c.setTextColorCenter(this.s);
        this.f50022b.setTextColorCenter(this.s);
        this.f50025e.setTextColorCenter(this.s);
        this.f50026f.setTextColorCenter(this.s);
        this.f50027g.setTextColorCenter(this.s);
    }

    public void K(int i) {
        this.s = i;
        J();
    }

    public final void L() {
        this.f50024d.setTextColorOut(this.r);
        this.f50023c.setTextColorOut(this.r);
        this.f50022b.setTextColorOut(this.r);
        this.f50025e.setTextColorOut(this.r);
        this.f50026f.setTextColorOut(this.r);
        this.f50027g.setTextColorOut(this.r);
    }

    public void M(int i) {
        this.r = i;
        L();
    }

    public void N(int i, int i2, int i3, int i4, int i5, int i6) {
        this.f50024d.setTextXOffset(i);
        this.f50023c.setTextXOffset(i2);
        this.f50022b.setTextXOffset(i3);
        this.f50025e.setTextXOffset(i4);
        this.f50026f.setTextXOffset(i5);
        this.f50027g.setTextXOffset(i6);
    }

    public void O(View view) {
        this.f50021a = view;
    }

    public final String n() {
        int currentItem;
        boolean z;
        int currentItem2;
        StringBuilder sb = new StringBuilder();
        int currentItem3 = this.f50022b.getCurrentItem() + this.j;
        if (d.b.h0.b1.o.a.e.a.g(currentItem3) == 0) {
            currentItem2 = this.f50023c.getCurrentItem();
        } else if ((this.f50023c.getCurrentItem() + 1) - d.b.h0.b1.o.a.e.a.g(currentItem3) <= 0) {
            currentItem2 = this.f50023c.getCurrentItem();
        } else if ((this.f50023c.getCurrentItem() + 1) - d.b.h0.b1.o.a.e.a.g(currentItem3) == 1) {
            currentItem = this.f50023c.getCurrentItem();
            z = true;
            int[] b2 = d.b.h0.b1.o.a.e.b.b(currentItem3, currentItem, this.f50024d.getCurrentItem() + 1, z);
            sb.append(b2[0]);
            sb.append("-");
            sb.append(b2[1]);
            sb.append("-");
            sb.append(b2[2]);
            sb.append(" ");
            sb.append(this.f50025e.getCurrentItem());
            sb.append(":");
            sb.append(this.f50026f.getCurrentItem());
            sb.append(":");
            sb.append(this.f50027g.getCurrentItem());
            return sb.toString();
        } else {
            currentItem = this.f50023c.getCurrentItem();
            z = false;
            int[] b22 = d.b.h0.b1.o.a.e.b.b(currentItem3, currentItem, this.f50024d.getCurrentItem() + 1, z);
            sb.append(b22[0]);
            sb.append("-");
            sb.append(b22[1]);
            sb.append("-");
            sb.append(b22[2]);
            sb.append(" ");
            sb.append(this.f50025e.getCurrentItem());
            sb.append(":");
            sb.append(this.f50026f.getCurrentItem());
            sb.append(":");
            sb.append(this.f50027g.getCurrentItem());
            return sb.toString();
        }
        currentItem = currentItem2 + 1;
        z = false;
        int[] b222 = d.b.h0.b1.o.a.e.b.b(currentItem3, currentItem, this.f50024d.getCurrentItem() + 1, z);
        sb.append(b222[0]);
        sb.append("-");
        sb.append(b222[1]);
        sb.append("-");
        sb.append(b222[2]);
        sb.append(" ");
        sb.append(this.f50025e.getCurrentItem());
        sb.append(":");
        sb.append(this.f50026f.getCurrentItem());
        sb.append(":");
        sb.append(this.f50027g.getCurrentItem());
        return sb.toString();
    }

    public String o() {
        if (this.w) {
            return n();
        }
        StringBuilder sb = new StringBuilder();
        if (this.p == this.j) {
            int currentItem = this.f50023c.getCurrentItem();
            int i = this.l;
            if (currentItem + i == i) {
                sb.append(this.f50022b.getCurrentItem() + this.j);
                sb.append("-");
                sb.append(this.f50023c.getCurrentItem() + this.l);
                sb.append("-");
                sb.append(this.f50024d.getCurrentItem() + this.n);
                sb.append(" ");
                sb.append(this.f50025e.getCurrentItem());
                sb.append(":");
                sb.append(this.f50026f.getCurrentItem());
                sb.append(":");
                sb.append(this.f50027g.getCurrentItem());
            } else {
                sb.append(this.f50022b.getCurrentItem() + this.j);
                sb.append("-");
                sb.append(this.f50023c.getCurrentItem() + this.l);
                sb.append("-");
                sb.append(this.f50024d.getCurrentItem() + 1);
                sb.append(" ");
                sb.append(this.f50025e.getCurrentItem());
                sb.append(":");
                sb.append(this.f50026f.getCurrentItem());
                sb.append(":");
                sb.append(this.f50027g.getCurrentItem());
            }
        } else {
            sb.append(this.f50022b.getCurrentItem() + this.j);
            sb.append("-");
            sb.append(this.f50023c.getCurrentItem() + 1);
            sb.append("-");
            sb.append(this.f50024d.getCurrentItem() + 1);
            sb.append(" ");
            sb.append(this.f50025e.getCurrentItem());
            sb.append(":");
            sb.append(this.f50026f.getCurrentItem());
            sb.append(":");
            sb.append(this.f50027g.getCurrentItem());
        }
        return sb.toString();
    }

    public void p(boolean z) {
        this.f50024d.h(z);
        this.f50023c.h(z);
        this.f50022b.h(z);
        this.f50025e.h(z);
        this.f50026f.h(z);
        this.f50027g.h(z);
    }

    public final void q(WheelView wheelView) {
        if (this.x != null) {
            wheelView.setOnItemSelectedListener(new e());
        }
    }

    public final void r() {
        this.f50024d.setTextSize(this.q);
        this.f50023c.setTextSize(this.q);
        this.f50022b.setTextSize(this.q);
        this.f50025e.setTextSize(this.q);
        this.f50026f.setTextSize(this.q);
        this.f50027g.setTextSize(this.q);
    }

    public void s(boolean z) {
        this.f50022b.setCyclic(z);
        this.f50023c.setCyclic(z);
        this.f50024d.setCyclic(z);
        this.f50025e.setCyclic(z);
        this.f50026f.setCyclic(z);
        this.f50027g.setCyclic(z);
    }

    public final void t() {
        this.f50024d.setDividerColor(this.t);
        this.f50023c.setDividerColor(this.t);
        this.f50022b.setDividerColor(this.t);
        this.f50025e.setDividerColor(this.t);
        this.f50026f.setDividerColor(this.t);
        this.f50027g.setDividerColor(this.t);
    }

    public void u(int i) {
        this.t = i;
        t();
    }

    public final void v() {
        this.f50024d.setDividerType(this.v);
        this.f50023c.setDividerType(this.v);
        this.f50022b.setDividerType(this.v);
        this.f50025e.setDividerType(this.v);
        this.f50026f.setDividerType(this.v);
        this.f50027g.setDividerType(this.v);
    }

    public void w(WheelView.DividerType dividerType) {
        this.v = dividerType;
        v();
    }

    public void x(int i) {
        this.k = i;
    }

    public void y(String str, String str2, String str3, String str4, String str5, String str6) {
        if (this.w) {
            return;
        }
        if (str != null) {
            this.f50022b.setLabel(str);
        } else {
            this.f50022b.setLabel(this.f50021a.getContext().getString(R.string.pickerview_year));
        }
        if (str2 != null) {
            this.f50023c.setLabel(str2);
        } else {
            this.f50023c.setLabel(this.f50021a.getContext().getString(R.string.pickerview_month));
        }
        if (str3 != null) {
            this.f50024d.setLabel(str3);
        } else {
            this.f50024d.setLabel(this.f50021a.getContext().getString(R.string.pickerview_day));
        }
        if (str4 != null) {
            this.f50025e.setLabel(str4);
        } else {
            this.f50025e.setLabel(this.f50021a.getContext().getString(R.string.pickerview_hours));
        }
        if (str5 != null) {
            this.f50026f.setLabel(str5);
        } else {
            this.f50026f.setLabel(this.f50021a.getContext().getString(R.string.pickerview_minutes));
        }
        if (str6 != null) {
            this.f50027g.setLabel(str6);
        } else {
            this.f50027g.setLabel(this.f50021a.getContext().getString(R.string.pickerview_seconds));
        }
    }

    public final void z() {
        this.f50024d.setLineSpacingMultiplier(this.u);
        this.f50023c.setLineSpacingMultiplier(this.u);
        this.f50022b.setLineSpacingMultiplier(this.u);
        this.f50025e.setLineSpacingMultiplier(this.u);
        this.f50026f.setLineSpacingMultiplier(this.u);
        this.f50027g.setLineSpacingMultiplier(this.u);
    }
}
