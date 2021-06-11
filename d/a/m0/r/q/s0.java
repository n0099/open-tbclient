package d.a.m0.r.q;

import java.util.ArrayList;
import java.util.List;
import tbclient.LotteryRegular;
/* loaded from: classes3.dex */
public class s0 {

    /* renamed from: a  reason: collision with root package name */
    public List<Integer> f53795a;

    public void a(LotteryRegular lotteryRegular) {
        String str = lotteryRegular.regular;
        this.f53795a = new ArrayList();
        int size = lotteryRegular.chance.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f53795a.add(lotteryRegular.chance.get(i2));
        }
    }
}
