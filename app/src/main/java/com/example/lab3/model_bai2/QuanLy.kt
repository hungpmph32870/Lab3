package com.example.lab3.model_bai2

fun main(){
    var list = mutableListOf<TheMuon>()

    val the1 = TheMuon("Phung Manh Hung", 20, "MD18309", "PM01", 10, 30, "Sach01")
    val the2 = TheMuon("Ha Quang Huy", 21, "MD18308", "PM02", 8, 30, "Sach02")

    list.add(the1)
    list.add(the2)

    do {
        println("1. Xem danh sách thẻ mượn")
        println("2. Thêm thẻ mượn")
        println("3. xóa thẻ mượn")

        print("Chọn chức năng: ")
        var s = readLine()!!.toInt()

        when (s) {
            1 -> getThongTin(list)
            2 -> addTheMuon(list)
            3 -> deleteTheMuon(list)
        }

        print("Ban co muon tiep tuc khong? (y/n): ")
        var check = readLine()
        if (check.equals("n"))
            break
    } while (true)
}

fun getThongTin(listThe: MutableList<TheMuon>) {
    println("Thông tin các thẻ mượn")
    for (tm in listThe) {
        println("Mã thẻ mượn: ${tm.mapm}, Họ tên: ${tm.hoten}, Tuổi: ${tm.tuoi}, Lớp: ${tm.lop}, Ngày mượn: ${tm.ngaymuon}, Hạn trả: ${tm.hantra}, Số hiệu sách: ${tm.sohieusach}")
    }
}

fun addTheMuon(listThe: MutableList<TheMuon>) {
    print("Nhập họ tên sinh viên: ")
    var hoten = readLine()
    print("Nhập tuổi: ")
    var tuoi = readLine()!!.toInt()
    print("Nhập lớp: ")
    var lop = readLine()
    print("Nhập mã thẻ mượn: ")
    var matm = readLine()
    print("Ngày mượn: ")
    var ngaymuon = readLine()!!.toInt()
    print("Hạn trả: ")
    var hantra = readLine()!!.toInt()
    print("Số hiệu sách: ")
    var sohieusach = readLine()

    val tm = TheMuon(hoten!!, tuoi, lop!!, matm!!, ngaymuon, hantra, sohieusach!!)

    listThe.add(tm)

    getThongTin(listThe)
}

fun deleteTheMuon(listThe: MutableList<TheMuon>) {
    print("Nhập mã thẻ mượn cần xóa: ")
    var matm = readLine()
    var check = false
    for (tm in listThe) {
        if (tm.mapm.equals(matm)) {
            listThe.remove(tm)
            check = true
            break
        }
    }
    if (check == false)
        println("Giáo viên không tồn tại")
    getThongTin(listThe)
}