package d.b.h0.r.q;

import java.util.ArrayList;
import java.util.List;
import tbclient.LotteryRegular;
/* loaded from: classes3.dex */
public class s0 {

    /* renamed from: a  reason: collision with root package name */
    public List<Integer> f50881a;

    public void a(LotteryRegular lotteryRegular) {
        String str = lotteryRegular.regular;
        this.f50881a = new ArrayList();
        int size = lotteryRegular.chance.size();
        for (int i = 0; i < size; i++) {
            this.f50881a.add(lotteryRegular.chance.get(i));
        }
    }
}
