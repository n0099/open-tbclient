package org.msgpack.template;

import java.math.BigDecimal;
import org.msgpack.MessageTypeException;
/* loaded from: classes.dex */
public class BigDecimalTemplate extends AbstractTemplate<BigDecimal> {

    /* renamed from: a  reason: collision with root package name */
    static final BigDecimalTemplate f2852a = new BigDecimalTemplate();

    private BigDecimalTemplate() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // org.msgpack.template.d
    public void a(org.msgpack.packer.a aVar, BigDecimal bigDecimal, boolean z) {
        if (bigDecimal == null) {
            if (z) {
                throw new MessageTypeException("Attempted to write null");
            }
            aVar.d();
            return;
        }
        aVar.a(bigDecimal.toString());
    }

    public static BigDecimalTemplate a() {
        return f2852a;
    }
}
