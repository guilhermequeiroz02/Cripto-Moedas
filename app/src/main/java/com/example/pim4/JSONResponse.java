package com.example.pim4;

import java.util.List;

class JSONResponse {
    List<CryptoActive> data;
}

class CryptoActive {
    int id;
    String name, symbol;
    Currency quote;
}

class Currency {
    USD USD;
}

class USD {
    Double price;
}
