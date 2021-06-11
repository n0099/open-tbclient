package d.b.c.a.b;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes6.dex */
public interface s {

    /* renamed from: a  reason: collision with root package name */
    public static final s f69339a = new a();

    /* loaded from: classes6.dex */
    public static class a implements s {
        @Override // d.b.c.a.b.s
        public List<InetAddress> a(String str) throws UnknownHostException {
            if (str != null) {
                try {
                    return Arrays.asList(InetAddress.getAllByName(str));
                } catch (NullPointerException e2) {
                    UnknownHostException unknownHostException = new UnknownHostException("Broken system behaviour for dns lookup of " + str);
                    unknownHostException.initCause(e2);
                    throw unknownHostException;
                }
            }
            throw new UnknownHostException("hostname == null");
        }
    }

    List<InetAddress> a(String str) throws UnknownHostException;
}
